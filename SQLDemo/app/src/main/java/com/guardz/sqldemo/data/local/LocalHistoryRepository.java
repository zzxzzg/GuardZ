package com.guardz.sqldemo.data.local;

import android.database.Cursor;
import android.util.Log;

import com.guardz.sqldemo.HistoryModel;
import com.guardz.sqldemo.data.IHistoryRepository;
import com.guardz.sqldemo.data.bean.DTHistory;
import com.guardz.sqldemo.data.response.RESPHistoryList;
import com.squareup.sqldelight.SqlDelightStatement;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by yxwang on 2017/7/31.
 */

public class LocalHistoryRepository implements IHistoryRepository {
    @Override
    public long insertHistory(long art_id, String title) {
        HistoryModel.Insert_history insert_history = HistoryManager.INSTANCE.getInsertHistory();
        insert_history.bind(art_id, title);
        return HistoryManager.INSTANCE.getDatabase().executeInsert(DTHistory.TABLE_NAME,insert_history.program);
    }

    @Override
    public long updateHistory(long art_id, String title) {
        HistoryModel.Update_by_id update_history = HistoryManager.INSTANCE.getUpdateHistory();
        update_history.bind(title, art_id);
        return HistoryManager.INSTANCE.getDatabase().executeUpdateDelete(DTHistory.TABLE_NAME,update_history.program);
    }

    @Override
    public Observable<Long> totalCount() {
        SqlDelightStatement statement = DTHistory.FACTORY.total_count();

        Observable<Long> observable = HistoryManager.INSTANCE.getDatabase()
                .createQuery(DTHistory.TABLE_NAME,statement.statement,statement.args).mapToOne(new Function<Cursor, Long>() {
            @Override
            public Long apply(@NonNull Cursor cursor) throws Exception {
                return DTHistory.EXIST_BY_ID.map(cursor);
            }
        });
        return observable;
    }

    @Override
    public Observable<List<DTHistory>> selectByPage(int pageSize, int pageNumber) {
        SqlDelightStatement statement = DTHistory.FACTORY.select_by_page(pageSize,pageNumber);
        return HistoryManager.INSTANCE.getDatabase()
                .createQuery(DTHistory.TABLE_NAME,statement.statement,statement.args).mapToList(new Function<Cursor, DTHistory>() {
            @Override
            public DTHistory apply(@NonNull Cursor cursor) throws Exception {
                return DTHistory.SELECT_BY_PAGE.map(cursor);
            }
        });
    }

    @Override
    public Observable<Boolean> isExist(long art_id) {
        SqlDelightStatement statement = DTHistory.FACTORY.exist_by_id(art_id);

        Observable<Boolean> observable = HistoryManager.INSTANCE.getDatabase().createQuery(DTHistory.TABLE_NAME,statement.statement,statement.args).mapToOne(new Function<Cursor, Boolean>() {
            @Override
            public Boolean apply(@NonNull Cursor cursor) throws Exception {
                try{
                    long count = DTHistory.EXIST_BY_ID.map(cursor);
                    if(count>0){
                        return true;
                    }else{
                        return false;
                    }
                }finally {
                    cursor.close();
                }
            }
        });
        return observable;
    }



    @Override
    public Observable<List<DTHistory.SelectTotal>> selectTotal() {
        SqlDelightStatement statement = DTHistory.FACTORY.select_total();
        return HistoryManager.INSTANCE.getDatabase().createQuery(DTHistory.TABLE_NAME,statement.statement,statement.args)
                .mapToList(new Function<Cursor, DTHistory.SelectTotal>() {
                    @Override
                    public DTHistory.SelectTotal apply(@NonNull Cursor cursor) throws Exception {
                        Log.d("sss","stop for debug");
                        return DTHistory.SELECT_TOTAL.map(cursor);
                    }
                });
    }
}
