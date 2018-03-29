package com.guardz.dagger2.demo1.test2;

import dagger.Component;

/**
 * Created by yxwang on 2017/9/14.
 */

@Component(modules = NameModule.class)
@ReleaseableTest
public interface PersonComponent {
    Person inject(Person person);
}
