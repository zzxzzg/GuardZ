package com.guardz.dagger2demo.demo4;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by yxwang on 2017/9/15.
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AScope {
}
