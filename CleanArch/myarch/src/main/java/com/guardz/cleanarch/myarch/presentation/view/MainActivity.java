package com.guardz.cleanarch.myarch.presentation.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guardz.cleanarch.myarch.R;
import com.guardz.cleanarch.myarch.presentation.Contracts;

public class MainActivity extends AppCompatActivity implements Contracts.IMainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
