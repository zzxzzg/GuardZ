package com.guardz.cleanvision.presentation.presenter;

import com.guardz.cleanvision.presentation.Contracts;

/**
 * Created by yxwang on 2018/4/13.
 */

public class MainPresenter {
    public Contracts.IMainView mMainView;
    public MainPresenter(Contracts.IMainView mainView){
        mMainView = mainView;
    }
}
