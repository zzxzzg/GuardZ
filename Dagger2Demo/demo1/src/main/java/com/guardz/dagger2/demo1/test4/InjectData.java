package com.guardz.dagger2.demo1.test4;

import javax.inject.Inject;

/**
 * Created by yxwang on 2017/9/27.
 */

public class InjectData {
    @Inject
    HomePresenter mHomePresenter;

    public InjectData(){
        DaggerInjectDataComponent.builder().build().inject(this);
    }
}
