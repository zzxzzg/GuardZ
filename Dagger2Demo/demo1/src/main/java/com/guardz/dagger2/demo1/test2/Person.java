package com.guardz.dagger2.demo1.test2;


import com.google.common.base.Optional;

import javax.inject.Inject;

import dagger.releasablereferences.ForReleasableReferences;
import dagger.releasablereferences.ReleasableReferenceManager;

/**
 * Created by yxwang on 2017/9/14.
 */

public class Person {
    @Inject
    @Country("chinese")
    public Name mChineseName;

    @Inject
    @Country("foreigner")
    public Name mForeignerName;

//    @Inject
//    public TestClass1 mTestClass1;

    @Inject
    Optional<TestClass1> mTestClass1;

    @Inject
    @ForReleasableReferences(ReleaseableTest.class)
    public ReleasableReferenceManager mReleasableReferenceManager;

    void lowMemory() {
        mReleasableReferenceManager.releaseStrongReferences();
    }

    void highMemory() {
        mReleasableReferenceManager.restoreStrongReferences();
    }

    public Person(){

    }

    public void inject(){
        PersonComponent component = DaggerPersonComponent.builder().build();
        component.inject(this);
    }
}
