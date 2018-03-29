package com.guardz.appdemo;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by yxwang on 2017/9/26.
 */

@Component(modules = {AndroidInjectionModule.class,MainActivityModule.class})
@Singleton
public interface ApplicationComponent {
    void inject(AgentApplication agentApplication);
}
