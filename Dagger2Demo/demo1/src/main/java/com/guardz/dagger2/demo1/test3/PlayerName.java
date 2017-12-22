package com.guardz.dagger2.demo1.test3;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by yxwang on 2017/9/19.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PlayerName {
}
