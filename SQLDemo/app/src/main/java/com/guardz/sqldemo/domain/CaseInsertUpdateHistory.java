package com.guardz.sqldemo.domain;

import android.util.Log;

import com.guardz.sqldemo.data.IHistoryRepository;
import com.guardz.sqldemo.data.local.HistoryManager;
import com.guardz.sqldemo.data.local.LocalHistoryRepository;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by yxwang on 2017/8/1.
 */

public class CaseInsertUpdateHistory {

    private IHistoryRepository mHistoryRepository;

    public CaseInsertUpdateHistory(){
        mHistoryRepository = new LocalHistoryRepository();
    }

    public Observable<Long> insertOrUpdateHistory(final long art_id, final String title){
        return mHistoryRepository.isExist(art_id).map(new Function<Boolean, Long>() {
            @Override
            public Long apply(@NonNull Boolean aBoolean) throws Exception {
                Log.d("sss","art_id is "+art_id +"  is "+aBoolean);
                if(!aBoolean){
                    return insertItem(art_id, title);
                }else{
                    return updateItem(art_id, title);
                }
            }
        });
    }

    private long insertItem(final long art_id, final String title){
        return mHistoryRepository.insertHistory(art_id, title);
    }

    private long updateItem(final long art_id, final String title){
        return mHistoryRepository.updateHistory(art_id, title);
    }
}
