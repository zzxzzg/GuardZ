package com.guardz.dagger2.demo1;

import android.app.Application;

/**
 * Created by yxwang on 2017/9/13.
 */

public class AgentApplication extends Application {
    public ApplicationComponent mApplicationComponent;

    public UserComponent mUserComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder().build();
    }

    public void userLogin(){
        mUserComponent = mApplicationComponent.getUserComponent(new UserModule());
        //do something by the caller
        mUserComponent.getClassApplication();
        mUserComponent.getClassUser();

//        ActivityComponent activityComponent = mUserComponent.newActivityComponentBuilder().activity(XXX).build();
//        activityComponent.getClassApplication();
//        activityComponent.getClassUser();
//        activityComponent.getClassActivity();
    }

    public void userLogout(){
        mUserComponent = null;
    }
}
