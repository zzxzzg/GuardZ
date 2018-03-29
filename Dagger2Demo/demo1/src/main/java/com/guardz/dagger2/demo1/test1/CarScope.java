package com.guardz.dagger2.demo1.test1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by yxwang on 2017/9/15.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface CarScope {
}
