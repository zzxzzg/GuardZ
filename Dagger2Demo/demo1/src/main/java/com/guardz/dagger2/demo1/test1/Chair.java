package com.guardz.dagger2.demo1.test1;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by yxwang on 2017/9/13.
 */

public class Chair {

    @Inject
    public Chair(){
    }

    public void print(){
        Log.d("daggers","chair");
    }
}
