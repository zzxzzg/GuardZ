package com.guardz.dagger2.demo1.test3;

import com.google.auto.value.AutoAnnotation;

import java.util.HashSet;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/**
 * Created by yxwang on 2017/9/19.
 */

@Module
public class GameModule {
    @Provides
    @IntoMap
    @StringKey(value = "1")
    public Player getPlayer1(){
        return new Player("1");
    }

    @Provides
    @IntoMap
    @StringKey(value = "2")
    public Player getPlayer2(){
        return new Player("2");
    }

    @Provides
    @IntoMap
    @GameInfo(name = "game",price = 100f)
    public String getGameInfo(){
        return "gameinfo";
    }


//    @Provides
//    @ElementsIntoSet
//    public Set<Player> getPlayers(){
//        HashSet set =  new HashSet<>();
//        set.add(new Player("3"));
//        set.add(new Player("4"));
//        return set;
//    }
}
