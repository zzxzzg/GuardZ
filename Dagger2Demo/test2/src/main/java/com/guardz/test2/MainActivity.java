package com.guardz.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);
//        MainActivitySubComponent component = ((AgentApplication)getApplication())
//                .getAgentApplicationComponent()
//                .getMainActivityBuilder()
//                .activity(this)
//                .build();

        // do some thing!
    }
}
