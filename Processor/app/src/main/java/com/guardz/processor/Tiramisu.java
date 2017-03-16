package com.guardz.processor;

import com.guardz.Factory;

/**
 * Created by yxwang on 17/3/14.
 */
@Factory(
        type = Meal.class,
        id = "Tiramisu"
)
public class Tiramisu implements Meal {
    @Override
    public String getPrice() {
        return "10";
    }
}
