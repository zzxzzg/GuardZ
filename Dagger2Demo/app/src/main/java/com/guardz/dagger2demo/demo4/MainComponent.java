package com.guardz.dagger2demo.demo4;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by yxwang on 16-4-15.
 */
@Component(dependencies = BeanComponent.class)
@AScope
public interface MainComponent {
    void inject(User user);
    RealObj getRealObj();
}
