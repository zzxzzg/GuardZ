package com.guardz.dagger2.demo1.test1;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by yxwang on 2017/9/13.
 */
@Component(modules = ChairModule.class)
public interface CarComponent {
    Car inject(Car car);
    Wheel getWheel();
}
