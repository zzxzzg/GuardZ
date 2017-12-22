package com.guardz.dagger2.demo1.test4;

import dagger.Component;

/**
 * Created by yxwang on 2017/9/27.
 */

@Component(modules = BindsDataModule.class)
public interface InjectDataComponent {
    void inject(InjectData injectData);
}
