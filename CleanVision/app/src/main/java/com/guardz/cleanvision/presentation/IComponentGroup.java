package com.guardz.cleanvision.presentation;

/**
 * Created by yxwang on 2018/5/16.
 */

public interface IComponentGroup {

    void receiveProxy(Proxy proxy);

    class Proxy<T>{
        public String event;
        public T data;
    }
}
