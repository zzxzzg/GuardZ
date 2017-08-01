package com.guardz.sqldemo.presentation.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.guardz.sqldemo.R;
import com.guardz.sqldemo.presentation.Contacts;
import com.guardz.sqldemo.presentation.presenter.InsertPresenter;

/**
 * Created by yxwang on 2017/7/31.
 */

public class InsertActivity extends Activity implements Contacts.IInsertView{

    private EditText mIDEdit;
    private EditText mTitleEdit;
    private Button mConfirm;
    private InsertPresenter mInsertPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        mIDEdit = (EditText) findViewById(R.id.id);
        mTitleEdit = (EditText) findViewById(R.id.title);
        mConfirm = (Button) findViewById(R.id.confirm);

        mInsertPresenter = new InsertPresenter(this,this);

        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(mIDEdit.getText().toString())){
                    Toast.makeText(InsertActivity.this,"请输入id",Toast.LENGTH_SHORT);
                    return;
                }

                if(TextUtils.isEmpty(mTitleEdit.getText().toString())){
                    Toast.makeText(InsertActivity.this,"请输入Title",Toast.LENGTH_SHORT);
                    return;
                }

                mInsertPresenter.insertOrUpdate(Long.parseLong(mIDEdit.getText().toString()),mTitleEdit.getText().toString());

            }
        });

    }
}
