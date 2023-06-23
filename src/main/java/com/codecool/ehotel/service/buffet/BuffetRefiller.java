package com.codecool.ehotel.service.buffet;

import com.codecool.ehotel.constants.Constants;
import com.codecool.ehotel.model.Buffet;
import com.codecool.ehotel.model.MealDurability;
import com.codecool.ehotel.model.MealPortion;
import com.codecool.ehotel.model.MealType;
import com.codecool.ehotel.service.buffet.MealRefill;

import java.util.Collection;
import java.util.Random;

public class BuffetRefiller {

    public static void refillBuffet(Buffet buffet, Collection<MealRefill> mealRefills) {
        for (MealRefill mealRefill : mealRefills) {
            MealType mealType = MealType.valueOf(mealRefill.mealType());

            for (int i = 0; i < mealRefill.amount(); i++) {
                long currentTimeStamp = System.currentTimeMillis();
                MealDurability mealDurability = getRandomMealDurability();
                MealPortion mealPortion = new MealPortion(mealType.toString(), currentTimeStamp, mealDurability);
                buffet.addMealPortion(mealType.toString(), mealPortion);
            }
        }
    }

    private static MealDurability getRandomMealDurability() {
        MealDurability[] values = MealDurability.values();
        return values[Constants.RANDOM.nextInt(values.length)];
    }
}
