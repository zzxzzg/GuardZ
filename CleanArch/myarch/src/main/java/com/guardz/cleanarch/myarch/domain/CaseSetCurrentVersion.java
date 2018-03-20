package com.guardz.cleanarch.myarch.domain;


import com.guardz.cleanarch.appcommon.arch.domain.UseCase;
import com.guardz.cleanarch.myarch.data.repository.AppinfoRepository;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by yxwang on 2017/4/18.
 */

public class CaseSetCurrentVersion extends UseCase<CaseSetCurrentVersion.RequestValue,CaseSetCurrentVersion.ResponseValue> {

    private AppinfoRepository mRepository;

    @Override
    @Deprecated
    public Flowable<ResponseValue> asFlowable() {
        throw useCrF();
    }

    @Override
    @Deprecated
    public Observable<ResponseValue> asObservable() {
        throw useCrO();
    }

    @Override
    public Completable asCompletable() {
        mRepository = new AppinfoRepository();
        return mRepository.setCurrentVersionLauncher(getRequestValues().mVersionCode);
    }


    public static final class ResponseValue implements UseCase.ResponseValue{

    }

    public static final class RequestValue implements UseCase.RequestValues{
        public int mVersionCode;

        public RequestValue(int versionCode){
            mVersionCode =  versionCode;
        }
    }
}
