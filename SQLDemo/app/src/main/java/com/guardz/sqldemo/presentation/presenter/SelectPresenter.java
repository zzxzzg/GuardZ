package com.guardz.sqldemo.presentation.presenter;

import android.content.Context;
import android.util.Log;

import com.guardz.sqldemo.data.response.RESPHistoryList;
import com.guardz.sqldemo.domain.CaseQueryHistory;
import com.guardz.sqldemo.presentation.Contacts;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by yxwang on 2017/8/1.
 */

public class SelectPresenter {

    private Context mContext;
    private Contacts.ISelectView mSelectView;
    private CaseQueryHistory mCaseQueryHistory;

    public SelectPresenter(Context context,Contacts.ISelectView view){
        mContext = context;
        mSelectView = view;
        mCaseQueryHistory = new CaseQueryHistory();
    }

    public void select(int pageSize,int pageNumber){
        mCaseQueryHistory.selectTotal(pageSize, pageNumber).take(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RESPHistoryList>() {
            @Override
            public void accept(@NonNull RESPHistoryList respHistoryList) throws Exception {
                mSelectView.updateList(respHistoryList.mHistoryList);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        });
    }
}
