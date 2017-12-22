package com.guardz.dagger2.demo1.test2;

import android.os.Message;

import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

/**
 * Created by yxwang on 2017/9/14.
 */

@Module(includes = TestModule1.class)
public class NameModule {
    @Provides
    @Reusable
    @Country("chinese")
    public Name providerChineseName(){
        return new Name("里","西斯");
    }

    @Provides
    @ReleaseableTest
    @Country("foreigner")
    public Name providerForeignerName(){
        return new Name("sk","white");
    }

    @Provides
    public TestClass1 getTestClass1(){
        return new TestClass1();
    }
}
