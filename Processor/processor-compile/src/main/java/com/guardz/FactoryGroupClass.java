package com.guardz;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * Created by yxwang on 17/3/15.
 */
//记录工厂类
public class FactoryGroupClass {

    //产品基类（接口）全名
    private String mQualifiedClassName;

    //记录所有 产品id : 产品
    private Map<String, FactoryAnnotatedClass> mProductMaps =
            new LinkedHashMap<String, FactoryAnnotatedClass>();

    public FactoryGroupClass(String qualifiedClassName){
        mQualifiedClassName =  qualifiedClassName;
    }

    public void add(FactoryAnnotatedClass toInsert){
        FactoryAnnotatedClass existing = mProductMaps.get(toInsert.getId());
        if(existing!=null){
            throw new IdAlreadyUsedException(existing);
        }
        mProductMaps.put(toInsert.getId(),toInsert);
    }

    public void generateCode(Elements elementUtils, Filer filer) throws IOException{
        TypeElement mealType = elementUtils.getTypeElement(mQualifiedClassName);
        ClassName meal = ClassName.get(mealType);

        ParameterSpec id = ParameterSpec.builder(String.class, "id")
                .addModifiers(Modifier.FINAL)
                .build();

        MethodSpec.Builder createBuilder = MethodSpec.methodBuilder("create")
                .addModifiers(Modifier.PUBLIC)
                .returns(meal)
                .addParameter(id);

        createBuilder.beginControlFlow("if($N == null)",id)
                .addStatement("throw new $T(\"id is null!\")",IllegalArgumentException.class)
                .endControlFlow();

        for(FactoryAnnotatedClass product : mProductMaps.values()){
            ClassName pClass = ClassName.get(product.getAnnotatedClassElement());

            createBuilder.beginControlFlow("if($N.equals($S))",id,product.getId())
                    .addStatement("return new $T()",pClass)
                    .endControlFlow();
        }

        createBuilder.addStatement("throw new $T(\"Unknown id = \"+ $N)",IllegalArgumentException.class,id);

        MethodSpec create = createBuilder.build();

        TypeSpec factory = TypeSpec.classBuilder(mealType.getSimpleName()+"Factory")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(create)
                .build();

        JavaFile file = JavaFile.builder(meal.packageName(),factory).build();
        file.writeTo(filer);
    }

    public class IdAlreadyUsedException extends RuntimeException{
        private FactoryAnnotatedClass mExisting;
        public IdAlreadyUsedException(FactoryAnnotatedClass existing){
            super(String.format("The item %s is existing!",existing.getId()));
            mExisting =  existing;
        }

        public FactoryAnnotatedClass getExisting() {
            return mExisting;
        }
    }
}
