package com.guardz.rxjava2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guardz.rxjava2lib.TestClass;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestClass testClass = new TestClass();
    }
}
