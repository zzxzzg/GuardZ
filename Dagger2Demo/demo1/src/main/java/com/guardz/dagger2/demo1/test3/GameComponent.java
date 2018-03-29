package com.guardz.dagger2.demo1.test3;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoAnnotation;

import java.util.Map;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by yxwang on 2017/9/19.
 */

@Component(modules = GameModule.class)
public interface GameComponent {
//    GameMode getGameMode();

    Game inject(Game game);

    //Map<GameInfo, String> myKeyStringMap();
//    @Component.Builder
//    interface Builder{
//        @BindsInstance Builder gameModeName(@GameModeName String str);
//        @BindsInstance Builder playerName(@PlayerName String str);
//        GameComponent build();
//    }
}
