package com.guardz.dagger2.demo1;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yxwang on 2017/9/18.
 */

@Module
public class ApplicationModule {
    private AgentApplication mAgentApplication;
    public ApplicationModule(AgentApplication agentApplication){
        mAgentApplication = agentApplication;
    }

    @Provides @Singleton public AgentApplication getAgentApplication(){
        return mAgentApplication;
    }

    @Provides @Singleton public ClassApplication getClassApplication(){
        return new ClassApplication();
    }
}
