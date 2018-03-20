/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.guardz.cleanarch.appcommon.arch.domain;


import com.guardz.cleanarch.appcommon.arch.domain.exception.MethodInvalidException;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Use cases are the entry points to the domain layer.
 *
 * @param <Q> the request type
 * @param <P> the response type
 */
public abstract class UseCase<Q extends UseCase.RequestValues, P extends UseCase.ResponseValue> {

    private Q mRequestValues;

    private UseCaseCallback<P> mUseCaseCallback;

    public void setRequestValues(Q requestValues) {
        mRequestValues = requestValues;
    }

    public Q getRequestValues(){
        return mRequestValues;
    }

    private void setUseCaseCallback(UseCaseCallback<P> useCaseCallback) {
        mUseCaseCallback = useCaseCallback;
    }

    protected UseCaseCallback<P> getUseCaseCallback(){
        return mUseCaseCallback;
    }

    public abstract Flowable<P> asFlowable();

    @Deprecated
    public Observable<P> asObservable(){
        return null;
    }

    @Deprecated
    public Completable asCompletable(){
        return null;
    }

    @Deprecated
    public Single<P> asSingle(){
        return null;
    }

    @Deprecated
    public Maybe<P> asMaybe(){
        return null;
    }

    protected RuntimeException useOrC(){
        return MethodInvalidException.getInstance(this.getClass().getSimpleName(),"asCompletable","asObservable");
    }

    protected RuntimeException useFrO(){
        return MethodInvalidException.getInstance(this.getClass().getSimpleName(),"asFlowable","asObservable");
    }

    protected RuntimeException useCrO(){
        return MethodInvalidException.getInstance(this.getClass().getSimpleName(),"asObservable","asCompletable");
    }

    protected RuntimeException useCrF(){
        return MethodInvalidException.getInstance(this.getClass().getSimpleName(),"asCompletable","asFlowable");
    }

    /**
     * Data passed to a request.
     */
    public interface RequestValues {
    }

    /**
     * Data received from a request.
     */
    public interface ResponseValue {
    }


    public interface UseCaseCallback<R> {
        void onSuccess(R response);
        void onError(Throwable throwable);
    }
}
