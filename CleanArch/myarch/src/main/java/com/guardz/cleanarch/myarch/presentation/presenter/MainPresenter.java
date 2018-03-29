package com.guardz.cleanarch.myarch.presentation.presenter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.guardz.cleanarch.myarch.domain.CaseLoadPageSwitch;
import com.guardz.cleanarch.myarch.domain.CaseSetCurrentVersion;
import com.guardz.cleanarch.myarch.presentation.Contracts;

import io.reactivex.CompletableObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yxwang on 2018/3/20.
 */

public class MainPresenter {
    CaseSetCurrentVersion mCaseSetCurrentVersion;
    CaseLoadPageSwitch mLoadPageSwitch;

    Context mContext;
    public MainPresenter(Contracts.IMainActivity activity,Context context){
        mCaseSetCurrentVersion = new CaseSetCurrentVersion();
        mLoadPageSwitch = new CaseLoadPageSwitch();
        mContext = context;
        launcher();
    }

    public void setCurrentVersion(){
        int versionCode = getVersionCode(mContext);
        CaseSetCurrentVersion.RequestValue requestValue =  new CaseSetCurrentVersion.RequestValue(versionCode);
        mCaseSetCurrentVersion.setRequestValues(requestValue);
        mCaseSetCurrentVersion.asCompletable().subscribeOn(Schedulers.io()).subscribe();
    }


    public void launcher(){
        int versionCode = getVersionCode(mContext);
        CaseLoadPageSwitch.RequestValue requestValue = new CaseLoadPageSwitch.RequestValue(versionCode);
        mLoadPageSwitch.setRequestValues(requestValue);
        mLoadPageSwitch.asObservable().subscribe(new Consumer<CaseLoadPageSwitch.ResponseValue>() {
            @Override
            public void accept(@NonNull CaseLoadPageSwitch.ResponseValue responseValue) throws Exception {
                if(responseValue.isFirstLauncher){
                    setCurrentVersion();
                    //mLauncherView.loadIntroView();
                }else{
                    //mLauncherView.loadMainView();
                }
            }
        });
    }

    public static int getVersionCode(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
