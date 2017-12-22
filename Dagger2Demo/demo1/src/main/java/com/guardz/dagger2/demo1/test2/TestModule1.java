package com.guardz.dagger2.demo1.test2;

import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.Provides;

/**
 * Created by yxwang on 2017/9/19.
 */

@Module
public abstract class TestModule1 {
    @BindsOptionalOf
    abstract TestClass1 optionalTestClass1();
}
