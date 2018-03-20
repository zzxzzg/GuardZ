package com.guardz.cleanarch.appcommon.arch.domain.exception;

/**
 * Created by yxwang on 2017/4/18.
 */

public class MethodInvalidException extends RuntimeException{

    public static MethodInvalidException getInstance(String className,String methodName,String... args){
        String msg;
        msg ="The method "+className+"."+methodName+" is invalid, please use ";
        for(String arg:args){
            msg +=className+"."+arg+" ";
        }
        return new MethodInvalidException(msg);
    }
    public MethodInvalidException(String msg){
        super(msg);

    }
}
