package com.guardz.cleanarch.myarch.data.local;

import android.content.Context;
import android.content.SharedPreferences;


import com.guardz.cleanarch.appcommon.util.SharedPreferencesUtils;
import com.guardz.cleanarch.myarch.data.IAppinfoRepository;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by yxwang on 2017/4/13.
 */

public class PreferenceAppinfo extends IAppinfoRepository {
    private SharedPreferences mPreferences;
    public PreferenceAppinfo(){
        mPreferences = SharedPreferencesUtils.getSharedPreferences(
                SharedPreferencesUtils.FileName.NORMAL_PREFERENCE,
                Context.MODE_PRIVATE
        );
    }

    @Override
    public Observable<Integer> getCurrentVersionObservable() {
        Observable<Integer> integerObservable= getObservable(new RepositoryCallback<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) {
                int version = mPreferences.getInt(SharedPreferencesUtils.Key.APP_VERSION,-1);
                e.onNext(version);
                e.onComplete();
            }
        });
        return integerObservable;
    }

    @Override
    public Flowable<Integer> getCurrentVersionFlowable() {
        Flowable<Integer> integerFlowable = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<Integer> e) throws Exception {
                int version = mPreferences.getInt(SharedPreferencesUtils.Key.APP_VERSION,-1);
                e.onNext(version);
                e.onComplete();
            }
        }, BackpressureStrategy.MISSING);
        return integerFlowable;
    }

    @Override
    public Single<Integer> getCurrentVersionSingle() {
        Single<Integer> single = Single.create(new SingleOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<Integer> e) throws Exception {
                int version = mPreferences.getInt(SharedPreferencesUtils.Key.APP_VERSION,-1);
                e.onSuccess(version);
            }
        });
        return single;
    }

    @Override
    public Maybe<Integer> getCurrentVersionMaybe() {
        Maybe<Integer> maybe = Maybe.create(new MaybeOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull MaybeEmitter<Integer> e) throws Exception {
                int version = mPreferences.getInt(SharedPreferencesUtils.Key.APP_VERSION,-1);
                e.onSuccess(version);
            }
        });
        return maybe;
    }

    @Override
    public Completable setCurrentVersionLauncher(final int currentVersion) {
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(@NonNull CompletableEmitter e) throws Exception {
                mPreferences.edit().putInt(SharedPreferencesUtils.Key.APP_VERSION,currentVersion).commit();
                e.onComplete();
            }
        });
    }

    @Override
    public Completable setDownloadId(final long id) {
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(@NonNull CompletableEmitter e) throws Exception {
                mPreferences.edit().putLong(SharedPreferencesUtils.Key.UPGRADE_DOWNLOAD_ID,id).commit();
                e.onComplete();
            }
        });
    }

    @Override
    public Single<Long> getDownloadId() {
        Single<Long> single = Single.create(new SingleOnSubscribe<Long>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<Long> e) throws Exception {
                long version = mPreferences.getLong(SharedPreferencesUtils.Key.UPGRADE_DOWNLOAD_ID,-1);
                e.onSuccess(version);
            }
        });
        return single;
    }

    @Override
    public Completable setIgnoreVersion(final int id) {
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(@NonNull CompletableEmitter e) throws Exception {
                mPreferences.edit().putInt(SharedPreferencesUtils.Key.IGNORE_VERSION,id).commit();
                e.onComplete();
            }
        });
    }

    @Override
    public int getIgnoreVersion() {
          return  mPreferences.getInt(SharedPreferencesUtils.Key.IGNORE_VERSION,-1);
    }
}
