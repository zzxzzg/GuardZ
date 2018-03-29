package com.guardz.cleanarch.appcommon.arch.data;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by yxwang on 2017/4/13.
 */

public abstract class IRepository {
    public  <P> Observable<P> getObservable(final RepositoryCallback<P> repositoryCallback){
        Observable<P> observable = Observable.create(new ObservableOnSubscribe<P>() {
            @Override
            public void subscribe(@NonNull final ObservableEmitter<P> e) throws Exception {
                repositoryCallback.subscribe(e);
            }
        });
        return observable;
    }



    public interface RepositoryCallback<T>{
        public void subscribe(@NonNull final ObservableEmitter<T> e);
    }
}
