package com.guardz.cleanarch.myarch.domain;

import com.guardz.cleanarch.appcommon.arch.domain.UseCase;
import com.guardz.cleanarch.myarch.data.repository.AppinfoRepository;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by yxwang on 2017/4/12.
 */

public class CaseLoadPageSwitch extends UseCase<CaseLoadPageSwitch.RequestValue,CaseLoadPageSwitch.ResponseValue> {

    private AppinfoRepository mRepository;

    @Override
    public Flowable<ResponseValue> asFlowable() {
        mRepository = new AppinfoRepository();
        return mRepository.getCurrentVersionFlowable().map(new Function<Integer, ResponseValue>() {
            @Override
            public ResponseValue apply(@NonNull Integer version) throws Exception {
                return opValue(version);
            }
        });
    }

    @Override
    public Observable<ResponseValue> asObservable() {
        mRepository = new AppinfoRepository();
        return mRepository.getCurrentVersionObservable().map(new Function<Integer, ResponseValue>() {
            @Override
            public ResponseValue apply(@NonNull Integer version) throws Exception {
                return opValue(version);
            }
        });
    }

    private ResponseValue opValue(Integer version){
        ResponseValue responseValue = new ResponseValue();
        if(version == -1 || version!=getRequestValues().mVersionCode){
            responseValue.isFirstLauncher=true;
        }else{
            responseValue.isFirstLauncher=false;
        }
        return responseValue;
    }

    public static final class ResponseValue implements UseCase.ResponseValue{
        public boolean isFirstLauncher;
    }

    public static final class RequestValue implements UseCase.RequestValues{
        public int mVersionCode;

        public RequestValue(int versionCode){
            mVersionCode =  versionCode;
        }
    }
}
