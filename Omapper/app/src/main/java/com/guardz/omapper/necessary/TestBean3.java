package com.guardz.omapper.necessary;

import android.support.annotation.Keep;

import org.omapper.annotations.Implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yxwang on 16/9/27.
 */
@Keep
public class TestBean3 {
    @Implementation(name = ArrayList.class)
    List<TestBean1> bean1s;
}
