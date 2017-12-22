package com.guardz.dagger2.demo1.test1;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;
import dagger.Provides;

/**
 * Created by yxwang on 2017/9/13.
 */

public class Car {
    @Inject
    Lazy<Chair> mChain;

    @Inject
    Provider<Wheel> mWheel;

    public Car(){
    }

    public void inject(){
        CarComponent carComponent = DaggerCarComponent.builder().chairModule(new ChairModule()).build();
        carComponent.inject(this);
    }


    public void print(){
        mChain.get().print();
        mWheel.get().print();
        Log.d("dagger2","car " + this.toString());
    }
}
