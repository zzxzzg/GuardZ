package com.guardz.sqldemo.presentation.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.guardz.sqldemo.R;
import com.guardz.sqldemo.data.local.HistoryManager;

public class MainActivity extends AppCompatActivity {

    private Button mInsertBtn;
    private Button mSelectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HistoryManager.INSTANCE.init(getApplicationContext());
        setContentView(R.layout.activity_main);
        mInsertBtn = (Button) findViewById(R.id.insert);
        mInsertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,InsertActivity.class);
                startActivity(intent);
            }
        });

        mSelectBtn = (Button) findViewById(R.id.select);
        mSelectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                startActivity(intent);
            }
        });
    }
}
