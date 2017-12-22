package com.guardz.dagger2.demo1;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by yxwang on 2017/9/18.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    UserComponent getUserComponent(UserModule userModule);
}


//@Singleton
//@Component(modules = AndroidInjectionModule.class)
//public interface ApplicationComponent {
//    UserComponent getUserComponent(UserModule userModule);
//}