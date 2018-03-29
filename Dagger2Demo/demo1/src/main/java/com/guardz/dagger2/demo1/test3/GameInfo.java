package com.guardz.dagger2.demo1.test3;


import java.lang.annotation.Retention;

import dagger.MapKey;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by yxwang on 2017/9/22.
 */
@MapKey(unwrapValue = false)
@Retention(value=RUNTIME)
public @interface GameInfo {
    String name();
    float price();
}
