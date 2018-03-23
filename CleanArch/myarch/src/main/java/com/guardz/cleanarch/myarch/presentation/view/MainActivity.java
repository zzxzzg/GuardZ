package com.guardz.cleanarch.myarch.presentation.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guardz.cleanarch.myarch.R;
import com.guardz.cleanarch.myarch.presentation.Contracts;
import com.guardz.cleanarch.myarch.presentation.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements Contracts.IMainActivity {

    MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this,this);
    }
}
