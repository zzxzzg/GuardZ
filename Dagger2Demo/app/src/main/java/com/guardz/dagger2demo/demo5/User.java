package com.guardz.dagger2demo.demo5;

import javax.inject.Inject;

/**
 * Created by yxwang on 16-4-15.
 */
public class User {
    @Inject
    SomeClassB someClassB;

    @Inject
    SomeClassA someClassA;
//
//    @Inject
//    SomeClassC someClassC;

    public User(){
        AComponent aComponent=DaggerAComponent.builder().aModule(new AModule()).build();
        BComponent bComponent=aComponent.getBComponent(new BModule());
        //CComponent cComponent = bComponent.getCComponent(new CModule());
        bComponent.inject(this);
    }
}
