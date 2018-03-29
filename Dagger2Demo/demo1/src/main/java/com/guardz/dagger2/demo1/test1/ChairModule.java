package com.guardz.dagger2.demo1.test1;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yxwang on 2017/9/13.
 */

@Module
public class ChairModule {
    @Provides
    public Chair provideChair(){
        return new Chair();
    }

    @Provides
    Wheel provideWheel(Shape shape){
        return new Wheel(shape);
    }

    @Provides
    public Shape provideShape(){
        return new Shape();
    }
}
