package com.guardz.dagger2.demo1.test2;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import dagger.releasablereferences.CanReleaseReferences;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by yxwang on 2017/9/19.
 */

@Documented
@Retention(RUNTIME)
@CanReleaseReferences
@Scope
public @interface ReleaseableTest {
}
