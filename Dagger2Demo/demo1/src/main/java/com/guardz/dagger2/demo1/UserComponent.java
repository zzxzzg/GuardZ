package com.guardz.dagger2.demo1;

import dagger.Subcomponent;

/**
 * Created by yxwang on 2017/9/18.
 */

@UserScope
@Subcomponent(modules = UserModule.class)
public interface UserComponent {
    //ActivityComponent getActivityComponent(ActivityModule activityModule);
    ActivityComponent.ActivityBuilder newActivityComponentBuilder();
    ClassApplication getClassApplication();
    ClassUser getClassUser();
}
