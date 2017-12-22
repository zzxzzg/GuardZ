package com.guardz.dagger2demo.demo5;

import dagger.Subcomponent;

/**
 * Created by yxwang on 16-4-15.
 */
@Subcomponent(modules = CModule.class)
public interface CComponent {
    void inject(User user);
}
