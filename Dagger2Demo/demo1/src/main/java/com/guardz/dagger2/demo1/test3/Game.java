package com.guardz.dagger2.demo1.test3;

import com.google.auto.value.AutoAnnotation;

import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

/**
 * Created by yxwang on 2017/9/19.
 */

public class Game {
    @Inject
    Map<String,Player> mPlayers;

    @Inject
    Map<GameInfo,String> mGameInfoStringMap;

    @Inject
    Map<String,Player> mPlayerMap;

    public Game(){
//        GameComponent component = DaggerGameComponent.builder().gameModeName("hard").playerName("yxwang").build();
//        component.getGameMode();
        GameComponent component = DaggerGameComponent.builder().build();
        component.inject(this);
    }
}
