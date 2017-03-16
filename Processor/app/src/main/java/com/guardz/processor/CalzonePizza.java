package com.guardz.processor;

import com.guardz.Factory;

/**
 * Created by yxwang on 17/3/14.
 */
@Factory(
        type = Meal.class,
        id = "CalzonePizza"
)
public class CalzonePizza implements Meal {
    @Override
    public String getPrice() {
        return "15";
    }
}
