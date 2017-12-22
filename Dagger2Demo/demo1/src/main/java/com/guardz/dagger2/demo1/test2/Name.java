package com.guardz.dagger2.demo1.test2;

import android.util.Log;

/**
 * Created by yxwang on 2017/9/14.
 */

public class Name {
    public String mFirstName;
    public String mLastName;
    public Name(String firstName,String lastName){
        mFirstName = firstName;
        mLastName = lastName;
    }

    public void print(){
        Log.d("dagger2",mFirstName + " "+mLastName);
    }
}
