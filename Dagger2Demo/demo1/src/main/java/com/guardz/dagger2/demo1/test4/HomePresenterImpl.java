package com.guardz.dagger2.demo1.test4;

import javax.inject.Inject;

/**
 * Created by yxwang on 2017/9/27.
 */

public class HomePresenterImpl implements HomePresenter{

    @Inject
    public HomePresenterImpl(UserService userService){

    }
}
