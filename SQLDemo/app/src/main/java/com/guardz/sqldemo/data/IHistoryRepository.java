package com.guardz.sqldemo.data;

import com.guardz.sqldemo.data.bean.DTHistory;
import com.guardz.sqldemo.data.response.RESPHistoryList;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by yxwang on 2017/7/31.
 */

public interface IHistoryRepository {
    long insertHistory(long art_id,String title);
    long updateHistory(long art_id,String title);
    Observable<Long> totalCount();
    Observable<List<DTHistory>> selectByPage(int pageSize,int pageNumber);

    Observable<Boolean> isExist(long art_id);


    /**
     * 这条语句没有实际意义，效果是是返回最后一条数据，但是在此处用来当做当做一个mapper的例子
     * @return
     */
    Observable<List<DTHistory.SelectTotal>> selectTotal();
}
