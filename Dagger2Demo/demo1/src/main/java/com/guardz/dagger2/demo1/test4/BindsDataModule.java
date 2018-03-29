package com.guardz.dagger2.demo1.test4;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by yxwang on 2017/9/27.
 */

@Module
public abstract class BindsDataModule {

    @Binds
    public abstract HomePresenter bindHomePresenter(HomePresenterImpl homePresenterImpl);
}
