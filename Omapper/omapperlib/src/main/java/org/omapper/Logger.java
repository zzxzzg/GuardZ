package org.omapper;

/**
 * Created by yxwang on 2017/5/10.
 */

public class Logger {

    public static Logger getLogger(Class clazz){
        return new Logger();
    }

    public boolean isDebugEnabled(){
        return false;
    }

    public void debug(String string){

    }

    public void error(String string,Throwable throwable){

    }

}
