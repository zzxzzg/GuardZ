package com.guardz.cleanarch.myarch.data;

import com.guardz.cleanarch.appcommon.arch.data.IRepository;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by yxwang on 2017/4/13.
 */

public abstract class IAppinfoRepository extends IRepository {

    public abstract Observable<Integer> getCurrentVersionObservable();

    public abstract Flowable<Integer> getCurrentVersionFlowable();

    public abstract Single<Integer> getCurrentVersionSingle();

    public abstract Maybe<Integer> getCurrentVersionMaybe();

    public abstract Completable setCurrentVersionLauncher(int currentVersion);

    public abstract Completable setDownloadId(long id);

    public abstract Single<Long> getDownloadId();

    public abstract Completable setIgnoreVersion(int id);

    public abstract int getIgnoreVersion();
}
