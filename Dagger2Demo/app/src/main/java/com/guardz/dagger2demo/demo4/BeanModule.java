package com.guardz.dagger2demo.demo4;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yxwang on 16-4-15.
 */
@Module
public class BeanModule {
    @Provides
    @Singleton
    BeanTypeA providerBeanTypeA(){
        return new BeanTypeA();
    }

    @Provides
    @Singleton
    BeanTypeB providerBeanTypeB(){
        return new BeanTypeB();
    }
}
