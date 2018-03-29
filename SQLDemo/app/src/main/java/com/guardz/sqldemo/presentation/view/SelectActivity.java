package com.guardz.sqldemo.presentation.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guardz.sqldemo.R;
import com.guardz.sqldemo.data.bean.DTHistory;
import com.guardz.sqldemo.domain.CaseQueryHistory;
import com.guardz.sqldemo.presentation.Contacts;
import com.guardz.sqldemo.presentation.presenter.SelectPresenter;

import java.util.List;

/**
 * Created by yxwang on 2017/8/1.
 */

public class SelectActivity extends Activity implements Contacts.ISelectView{

    private LinearLayout mContainer;
    private Button mPreBtn;
    private Button mNextBtn;

    private int mPageSize = 5;
    private int mCurrentPage =1;

    private SelectPresenter mSelectPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        mContainer = (LinearLayout) findViewById(R.id.container);
        mSelectPresenter = new SelectPresenter(this,this);

        mPreBtn = (Button) findViewById(R.id.pre);
        mNextBtn = (Button) findViewById(R.id.next);

        mPreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentPage <= 1){
                    return;
                }
                mCurrentPage--;
                select();
            }
        });

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentPage++;
                select();
            }
        });
        select();
    }

    private void select(){
        mSelectPresenter.select(mPageSize,mCurrentPage);
    }

    @Override
    public void updateList(List<DTHistory> historyList) {
        mContainer.removeAllViews();
        for(DTHistory history:historyList){
            View view = getLayoutInflater().inflate(R.layout.item,null);
            TextView tv = (TextView) view.findViewById(R.id.text);
            tv.setText(history.title());
            mContainer.addView(view);
        }
    }
}
