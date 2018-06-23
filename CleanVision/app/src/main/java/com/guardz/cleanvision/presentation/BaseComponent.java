package com.guardz.cleanvision.presentation;

import android.view.ViewStub;

/**
 * Created by yxwang on 2018/4/13.
 */

public abstract class BaseComponent implements IComponentGroup{
    private ViewStub mViewStub;
    private IComponentGroup mGroup;

    public BaseComponent(ViewStub stub,IComponentGroup group){
        mViewStub = stub;
        mViewStub.setLayoutResource(getLayoutResource());
    }

    public abstract int getLayoutResource();

    public void inflate(){
        mViewStub.inflate();
    }

    //当该组件需要执行的某些行为自身无法承担，那么往上层抛出事件
    protected void dispatchProxy(IComponentGroup.Proxy proxy){
        if(mGroup!=null) {
            mGroup.receiveProxy(proxy);
        }
    }

    //默认直接向上抛出，子类应该要重写该方法，拦截需要处理的代理事件。
    @Override
    public void receiveProxy(Proxy proxy) {
        dispatchProxy(proxy);
    }
}
