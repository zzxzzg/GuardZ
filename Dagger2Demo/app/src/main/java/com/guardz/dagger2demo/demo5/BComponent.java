package com.guardz.dagger2demo.demo5;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by yxwang on 16-4-15.
 */
@Subcomponent(modules = BModule.class)
public interface BComponent {
    //CComponent getCComponent(CModule cModule);
    void inject(User user);
}
