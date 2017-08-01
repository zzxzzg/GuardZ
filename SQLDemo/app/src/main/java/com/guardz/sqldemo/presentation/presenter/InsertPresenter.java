package com.guardz.sqldemo.presentation.presenter;

import android.content.Context;
import android.util.Log;

import com.guardz.sqldemo.domain.CaseInsertUpdateHistory;
import com.guardz.sqldemo.presentation.Contacts;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by yxwang on 2017/8/1.
 */

public class InsertPresenter {

    private Context mContext;
    private Contacts.IInsertView mInsertView;
    private CaseInsertUpdateHistory mCaseInsertUpdateHistory;


    public InsertPresenter(Context context, Contacts.IInsertView view){
        mContext = context;
        mInsertView = view;
        mCaseInsertUpdateHistory = new CaseInsertUpdateHistory();
    }

    public void insertOrUpdate(long art_Id,String title){
        mCaseInsertUpdateHistory
                .insertOrUpdateHistory(art_Id, title)
                .take(1).subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        Log.d("sss","onNext");
                        if(aLong != -1){
                            //success
                        }else{
                            //fail
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.d("sss","onComplete");
                    }
                });
    }
}
