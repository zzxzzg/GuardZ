package com.guardz.dagger2.demo1;

import android.app.Activity;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by yxwang on 2017/9/18.
 */

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    ClassApplication getClassApplication();
    ClassActivity getClassActivity();
    ClassUser getClassUser();

    @Subcomponent.Builder
    interface ActivityBuilder{
        @BindsInstance ActivityBuilder activity(Activity activity);
        ActivityComponent build();
    }
}

//@ActivityScope
//@Subcomponent(modules = ActivityModule.class)
//public interface ActivityComponent extends AndroidInjector<MainActivity>{
//    @Subcomponent.Builder
//    public abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
//}
