package com.guardz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yxwang on 17/3/14.
 */
//自动生成工程，该注解用来标识工厂的产品
@Retention(value = RetentionPolicy.CLASS)
@Target(value = ElementType.TYPE)
public @interface Factory {
    //被注解类的基类 （产品的基类 接口）
    Class type();
    //被注解类的 id （产品id）
    String id();
}
