package com.guardz;

import com.google.auto.service.AutoService;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/**
 * Created by yxwang on 17/3/14.
 */
@AutoService(Processor.class)
@SupportedAnnotationTypes("com.guardz.Factory")
@SupportedOptions("module")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class FactoryProcessor extends AbstractProcessor {
    private Logger mLogger;
    private Types mTypesUtils;
    //一些element的操作辅助工具
    private Elements mElementUtils;
    private Filer mFiler;

    private Map<String, FactoryGroupClass> mFactoryGroupClassMap =
            new LinkedHashMap<String, FactoryGroupClass>();

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mLogger =  new Logger(processingEnv.getMessager());
        mLogger.info("FactoryProcessor init!!!");
        mElementUtils = processingEnv.getElementUtils();
        mTypesUtils = processingEnv.getTypeUtils();
        mFiler = processingEnv.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//        Iterator<? extends TypeElement> iterator = annotations.iterator();
//        while(iterator.hasNext()) {
//            TypeElement e = iterator.next();
//            mLogger.info("QualifiedName   "+e.getQualifiedName().toString());
//            mLogger.info("SimpleName   "+e.getSimpleName().toString());
//        }
        for (Element element : roundEnv.getElementsAnnotatedWith(Factory.class)){
            if(element.getKind()!= ElementKind.CLASS){
                mLogger.error(String.format("\"Only classes can be annotated with @%s",
                        Factory.class.getSimpleName()));
                return true;
            }

            TypeElement typeElement = (TypeElement) element;

            try{
                FactoryAnnotatedClass annotatedClass = new FactoryAnnotatedClass(typeElement);
                if(!isValidClass(annotatedClass)){
                    return true;
                }

                FactoryGroupClass factoryGroupClass = mFactoryGroupClassMap.get(annotatedClass.getQualifiedTypeName());
                if(factoryGroupClass == null){
                    String qualifiedTypeName = annotatedClass.getQualifiedTypeName();
                    factoryGroupClass = new FactoryGroupClass(qualifiedTypeName);
                    mFactoryGroupClassMap.put(qualifiedTypeName,factoryGroupClass);
                }
                factoryGroupClass.add(annotatedClass);

            }catch (IllegalArgumentException e){
                mLogger.error(e.getMessage());
                return true;
            }catch (FactoryGroupClass.IdAlreadyUsedException e){
                mLogger.error("Conflict: The class %s is annotated with @%s with id ='%s' but %s already uses the same id",
                        typeElement.getQualifiedName().toString(), Factory.class.getSimpleName(),
                        e.getExisting().getAnnotatedClassElement().getQualifiedName().toString());
                return true;
            }
        }

        try {
            for (FactoryGroupClass factoryGroupClass : mFactoryGroupClassMap.values()) {
                factoryGroupClass.generateCode(mElementUtils, mFiler);
            }
            mFactoryGroupClassMap.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    private boolean isValidClass(FactoryAnnotatedClass item){
        TypeElement classElement = item.getAnnotatedClassElement();

        //产品需要时public的
        if(!classElement.getModifiers().contains(Modifier.PUBLIC)){
            mLogger.error("The class %s is not public.",
                    classElement.getQualifiedName().toString());
            return false;
        }

        //产品不能是一个抽象类
        if(classElement.getModifiers().contains(Modifier.ABSTRACT)){
            mLogger.error("The class %s is abstract. You can't annotate abstract classes with @%",
                    classElement.getQualifiedName().toString(), Factory.class.getSimpleName());
            return false;
        }

        // 检查继承关系: 必须是@Factory.type()指定的类型子类
        TypeElement superClassElement = mElementUtils.getTypeElement(item.getQualifiedTypeName());
        if(superClassElement.getKind() == ElementKind.INTERFACE){
            //是否继承了该接口
            if (!classElement.getInterfaces().contains(superClassElement.asType())){
                mLogger.error("The class %s annotated with @%s must inherit from %s",
                        classElement.getQualifiedName().toString(),
                        Factory.class.getSimpleName(),
                        item.getQualifiedTypeName());
                return false;
            }
        }else{
            TypeElement currentElement = classElement;
            while(true) {
                TypeMirror superClassType = currentElement.getSuperclass();
                // 到达了基本类型(java.lang.Object), 所以退出
                if(superClassType.getKind() == TypeKind.NONE){
                    mLogger.error("The class %s annotated with @%s must inherit from %s",
                            classElement.getQualifiedName().toString(),
                            Factory.class.getSimpleName(),
                            item.getQualifiedTypeName());
                    return false;
                }

                //类名相同，找到了type所指的类
                if(superClassType.toString().equals(item.getQualifiedTypeName())){
                    break;
                }
                currentElement = (TypeElement) mTypesUtils.asElement(superClassType);
            }
        }

        //  检查是否提供了默认公开构造函数
        for(Element element:classElement.getEnclosedElements()){
            if(element.getKind() == ElementKind.CONSTRUCTOR){
                ExecutableElement  executableElement = (ExecutableElement) element;
                if(executableElement.getParameters().size() == 0 &&
                        executableElement.getModifiers().contains(Modifier.PUBLIC)){
                    //存在默认构造函数
                    return true;
                }
            }
        }
        mLogger.error("The class %s must provide an public empty default constructor",
                classElement.getQualifiedName().toString());
        return false;
    }

}
