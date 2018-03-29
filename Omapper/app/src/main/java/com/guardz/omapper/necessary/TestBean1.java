package com.guardz.omapper.necessary;

import android.support.annotation.Keep;

import org.omapper.annotations.Necessary;

/**
 * Created by yxwang on 16/9/27.
 */
@Keep
public class TestBean1 {

    @Necessary(necessary = true,nullable = false)
    String name;
    @Necessary(necessary = false,nullable = false)
    String nick;
    @Necessary(necessary = false,nullable = true)
    int age;
    @Necessary(necessary = true,nullable = true)
    String emp_id;
}
