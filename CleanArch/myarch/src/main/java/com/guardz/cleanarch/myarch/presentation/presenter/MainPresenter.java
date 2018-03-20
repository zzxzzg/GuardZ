package com.guardz.cleanarch.myarch.presentation.presenter;

import com.guardz.cleanarch.myarch.domain.CaseSetCurrentVersion;
import com.guardz.cleanarch.myarch.presentation.Contracts;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by yxwang on 2018/3/20.
 */

public class MainPresenter {
    CaseSetCurrentVersion mCaseSetCurrentVersion;
    public MainPresenter(Contracts.IMainActivity activity){
        mCaseSetCurrentVersion = new CaseSetCurrentVersion();

        mCaseSetCurrentVersion.asCompletable().subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
