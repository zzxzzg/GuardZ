package com.guardz.sqldemo.data.bean;

import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;
import com.guardz.sqldemo.HistoryModel;
import com.squareup.sqldelight.RowMapper;

/**
 * Created by yxwang on 2017/7/31.
 */
@AutoValue
public abstract class DTHistory implements HistoryModel,Parcelable {
    public static Factory<DTHistory> FACTORY = new Factory<>(new HistoryModel.Creator<DTHistory>() {
        @Override
        public DTHistory create(long _id, long art_id, @NonNull String title, long created_time) {
            return new AutoValue_DTHistory(_id, art_id, title, created_time);
        }
    });

    public static RowMapper<Long> EXIST_BY_ID = FACTORY.exist_by_idMapper();

    public static RowMapper<DTHistory> SELECT_BY_PAGE = FACTORY.select_by_pageMapper();


    //----------------------------
    /**
     * 这条语句没有实际意义，效果是是返回最后一条数据，但是在此处用来当做当做一个mapper的例子
     */
    public static RowMapper<SelectTotal> SELECT_TOTAL = FACTORY.select_totalMapper(new Select_totalCreator<DTHistory, SelectTotal>() {
        @Override
        public SelectTotal create(@NonNull DTHistory history, long count) {
            return new AutoValue_DTHistory_SelectTotal(history,count);
        }
    });

    @AutoValue
    public abstract static class SelectTotal implements Select_totalModel<DTHistory>{
    }
    //----------------------------

}
