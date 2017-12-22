package com.guardz.dagger2.demo1.test1;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by yxwang on 2017/9/13.
 */

public class Wheel {
    private Shape mShape;
    @Inject
    public Wheel(Shape shape){
        mShape = shape;
    }

    public void print(){
        mShape.print();
        Log.d("daggers","wheel" + hashCode());
    }
}
