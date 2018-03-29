package com.guardz.sqldemo.domain;

import android.util.Log;

import com.guardz.sqldemo.data.IHistoryRepository;
import com.guardz.sqldemo.data.bean.DTHistory;
import com.guardz.sqldemo.data.local.LocalHistoryRepository;
import com.guardz.sqldemo.data.response.RESPHistoryList;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by yxwang on 2017/8/1.
 */

public class CaseQueryHistory {

    private IHistoryRepository mHistoryRepository;

    public CaseQueryHistory(){
        mHistoryRepository = new LocalHistoryRepository();
    }

    public Observable<RESPHistoryList> selectTotal(final int pageSize, final int pageNumber){
        return mHistoryRepository.totalCount().flatMap(new Function<Long, ObservableSource<RESPHistoryList>>() {
            @Override
            public ObservableSource<RESPHistoryList> apply(@NonNull Long aLong) throws Exception {
                final RESPHistoryList respHistoryList = new RESPHistoryList();
                respHistoryList.mTotalCount = aLong;
                return mHistoryRepository.selectByPage(pageSize, pageNumber).map(new Function<List<DTHistory>, RESPHistoryList>() {
                    @Override
                    public RESPHistoryList apply(@NonNull List<DTHistory> dtHistories) throws Exception {
                        respHistoryList.mHistoryList = dtHistories;
                        return respHistoryList;
                    }
                });
            }
        });
    }
}
