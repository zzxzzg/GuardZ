package com.guardz.dagger2.demo1;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yxwang on 2017/9/18.
 */

@Module
public class ActivityModule {
    @Provides @ActivityScope public ClassActivity getClassActivity(){
        return new ClassActivity();
    }
}
