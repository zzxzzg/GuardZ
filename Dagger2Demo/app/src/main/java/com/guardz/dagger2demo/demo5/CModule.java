package com.guardz.dagger2demo.demo5;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yxwang on 16-4-15.
 */
@Module
public class CModule {
    @Provides
    SomeClassC providerSomeClassC(){
        return new SomeClassC();
    }
}
