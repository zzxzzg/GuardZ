package com.guardz.sqldemo.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.guardz.sqldemo.data.bean.DTHistory;

/**
 * Created by yxwang on 2017/7/31.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context,"history.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DTHistory.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
