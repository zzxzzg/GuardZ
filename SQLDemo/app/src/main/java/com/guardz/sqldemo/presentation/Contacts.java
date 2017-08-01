package com.guardz.sqldemo.presentation;

import com.guardz.sqldemo.data.bean.DTHistory;

import java.util.List;

/**
 * Created by yxwang on 2017/8/1.
 */

public class Contacts {
    public interface IInsertView{

    }

    public interface ISelectView{
        void updateList(List<DTHistory> historyList);
    }
}
