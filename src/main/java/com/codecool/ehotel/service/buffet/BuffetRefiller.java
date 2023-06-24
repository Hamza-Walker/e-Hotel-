package com.codecool.ehotel.service.buffet;

import com.codecool.ehotel.constants.Constants;
import com.codecool.ehotel.model.Buffet;
import com.codecool.ehotel.model.MealDurability;
import com.codecool.ehotel.model.MealPortion;
import com.codecool.ehotel.model.MealRefill;

import java.util.Collection;
import java.util.List;

public class BuffetRefiller {
    public static void refillBuffet(Buffet buffet, List<MealRefill> mealRefills) {
        for (MealRefill mealRefill : mealRefills) {
            String mealType = mealRefill.mealType();
            int refillAmount = mealRefill.amount();

            List<MealPortion> existingMealPortions = buffet.getMealPortions(mealType);
            int currentAmount = existingMealPortions.size();

            if (currentAmount < refillAmount) {
                int diff = refillAmount - currentAmount;
                for (int i = 0; i < diff; i++) {
                    long currentTimeStamp = System.currentTimeMillis();
                    MealDurability mealDurability = getRandomMealDurability();
                    MealPortion mealPortion = new MealPortion(mealType, currentTimeStamp, mealDurability);
                    buffet.addMealPortion(mealType, mealPortion);
                }
            }
        }
    }

    private static MealDurability getRandomMealDurability() {
        MealDurability[] values = MealDurability.values();
        return values[Constants.RANDOM.nextInt(values.length)];
    }
}

