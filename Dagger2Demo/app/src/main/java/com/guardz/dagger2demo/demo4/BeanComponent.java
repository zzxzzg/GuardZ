package com.guardz.dagger2demo.demo4;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by yxwang on 16-4-15.
 */
@Component(modules = BeanModule.class)
@Singleton
public interface BeanComponent {
    BeanTypeA getBeanTypeA();
    BeanTypeB getBeanTypeB();
}
