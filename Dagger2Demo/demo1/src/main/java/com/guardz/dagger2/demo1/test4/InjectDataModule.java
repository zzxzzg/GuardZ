package com.guardz.dagger2.demo1.test4;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yxwang on 2017/9/27.
 */

@Module
public class InjectDataModule {
    @Provides
    public HomePresenter getHomePresenter(UserService userService){
        return new HomePresenterImpl(userService);
    }

    @Provides UserService getUserService(){
        return new UserService();
    }
}
