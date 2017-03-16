package com.guardz.processor;

/**
 * Created by yxwang on 17/3/16.
 */

public class PizzaStore {
    private MealFactory mFactory = new MealFactory();
    public Meal order(String mealName) {
        return mFactory.create(mealName);
    }
}
