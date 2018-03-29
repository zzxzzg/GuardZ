package com.guardz.dagger2.demo1.test3;

import android.support.annotation.Nullable;

import javax.inject.Inject;

/**
 * Created by yxwang on 2017/9/19.
 */

public class GameMode {
    @Inject
    public GameMode(@GameModeName String gameName , @PlayerName String playerName){

    }
}
