package com.guardz.dagger2.demo1;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yxwang on 2017/9/18.
 */

@Module
public class UserModule {
    @Provides @UserScope public ClassUser getClassUser(){
        return new ClassUser();
    }
}
