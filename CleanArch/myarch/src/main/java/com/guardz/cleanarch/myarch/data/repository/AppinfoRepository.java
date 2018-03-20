package com.guardz.cleanarch.myarch.data.repository;

import com.guardz.cleanarch.myarch.data.IAppinfoRepository;
import com.guardz.cleanarch.myarch.data.local.PreferenceAppinfo;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by yxwang on 2017/4/13.
 */

public class AppinfoRepository extends IAppinfoRepository {
    private IAppinfoRepository preferenceAppinfo;

    public AppinfoRepository(){
        preferenceAppinfo = new PreferenceAppinfo();
    }

    @Override
    public Observable<Integer> getCurrentVersionObservable() {
        return preferenceAppinfo.getCurrentVersionObservable();
    }

    @Override
    public Flowable<Integer> getCurrentVersionFlowable() {
        return preferenceAppinfo.getCurrentVersionFlowable();
    }

    @Override
    public Single<Integer> getCurrentVersionSingle() {
        return preferenceAppinfo.getCurrentVersionSingle();
    }

    @Override
    public Maybe<Integer> getCurrentVersionMaybe() {
        return preferenceAppinfo.getCurrentVersionMaybe();
    }

    @Override
    public Completable setCurrentVersionLauncher(int currentVersion) {
        return preferenceAppinfo.setCurrentVersionLauncher(currentVersion);
    }

    @Override
    public Completable setDownloadId(long id) {
        return preferenceAppinfo.setDownloadId(id);
    }

    @Override
    public Single<Long> getDownloadId() {
        return preferenceAppinfo.getDownloadId();
    }

    @Override
    public Completable setIgnoreVersion(int id) {
        return preferenceAppinfo.setIgnoreVersion(id);
    }

    @Override
    public int getIgnoreVersion() {
        return preferenceAppinfo.getIgnoreVersion();
    }
}
