package com.guardz.test2;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by yxwang on 2017/10/10.
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class,MainActivityModule.class})
public interface AgentApplicationComponent {
    void inject(AgentApplication agentApplication);
}
