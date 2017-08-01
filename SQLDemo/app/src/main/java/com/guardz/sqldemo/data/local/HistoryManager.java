package com.guardz.sqldemo.data.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.guardz.sqldemo.HistoryModel;
import com.guardz.sqldemo.data.bean.DTHistory;
import com.squareup.sqlbrite2.BriteDatabase;
import com.squareup.sqlbrite2.QueryObservable;
import com.squareup.sqlbrite2.SqlBrite;
import com.squareup.sqldelight.SqlDelightStatement;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yxwang on 2017/7/31.
 */

public enum HistoryManager {
    INSTANCE;
    HistoryManager(){
    }

    private BriteDatabase mDatabase;
    private HistoryModel.Insert_history mInsertHistory;
    private HistoryModel.Update_by_id mUpdateHistory;

    public BriteDatabase getDatabase() {
        return mDatabase;
    }

    public HistoryModel.Insert_history getInsertHistory() {
        return mInsertHistory;
    }

    public HistoryModel.Update_by_id getUpdateHistory() {
        return mUpdateHistory;
    }

    public void init(Context context){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        mInsertHistory = new HistoryModel.Insert_history(database);
        mUpdateHistory = new HistoryModel.Update_by_id(database);

        SqlBrite sqlBrite = new SqlBrite.Builder().build();
        mDatabase = sqlBrite.wrapDatabaseHelper(dbHelper, Schedulers.io());
    }

}
