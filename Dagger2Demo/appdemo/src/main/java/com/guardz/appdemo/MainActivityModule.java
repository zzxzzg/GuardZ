package com.guardz.appdemo;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by yxwang on 2017/9/26.
 */

@Module(subcomponents = MainActivityComponent.class)
public abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindMainActivityInjectorFactory(MainActivityComponent.Builder builder);

    @Provides
    public static String getName(){
        return "hahaha";
    }
}
