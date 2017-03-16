package com.guardz;



import org.apache.commons.lang3.StringUtils;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;

/**
 * Created by yxwang on 17/3/15.
 */
//记录单个产品的类
public class FactoryAnnotatedClass {
    //产品节点
    private TypeElement mAnnotatedClassElement;

    /**
     * 产品type（基类） 全名
     */
    private String qualifiedTypeName;
    //产品type（基类）简单名
    private String simpleTypeName;
    //产品节点id
    private String mId;

    public FactoryAnnotatedClass(TypeElement element) throws IllegalArgumentException{
        mAnnotatedClassElement = element;
        Factory factory = element.getAnnotation(Factory.class);
        mId = factory.id();
        //id 不能为空
        if(StringUtils.isEmpty(mId)){
            throw new IllegalArgumentException(
                    String.format("id() in @%s for class %s is null or empty! that's not allowed",
                            Factory.class.getSimpleName(), element.getQualifiedName().toString()));
        }

        try{
           Class<?> clazz= factory.type();
            qualifiedTypeName = clazz.getCanonicalName();
            simpleTypeName = clazz.getSimpleName();
        }catch (MirroredTypeException mte){
            //由于processor需要考虑类没有被加载的时候的处理情况。
            DeclaredType classTypeMirror = (DeclaredType) mte.getTypeMirror();
            TypeElement classTypeElement = (TypeElement) classTypeMirror.asElement();
            qualifiedTypeName = classTypeElement.getQualifiedName().toString();
            simpleTypeName = classTypeElement.getSimpleName().toString();

        }
    }

    public TypeElement getAnnotatedClassElement() {
        return mAnnotatedClassElement;
    }

    /**
     * 获取在{@link Factory#type()}指定的类型合法全名
     *
     * @return qualified name
     */
    public String getQualifiedTypeName() {
        return qualifiedTypeName;
    }

    public String getSimpleTypeName() {
        return simpleTypeName;
    }

    public String getId() {
        return mId;
    }
}
