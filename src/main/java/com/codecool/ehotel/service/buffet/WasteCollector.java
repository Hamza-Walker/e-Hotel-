package com.codecool.ehotel.service.buffet;

import com.codecool.ehotel.model.Buffet;
import com.codecool.ehotel.model.MealDurability;
import com.codecool.ehotel.model.MealPortion;
import com.codecool.ehotel.model.MealType;

import java.util.Iterator;
import java.util.List;

public class WasteCollector {
    public static double collectWaste(Buffet buffet, MealDurability mealDurability) {
        List<List<MealPortion>> allMealPortions = buffet.getAllMealPortions();
        double sumCost = 0.0;

        for (List<MealPortion> mealPortions : allMealPortions) {
            Iterator<MealPortion> iterator = mealPortions.iterator();
            while (iterator.hasNext()) {
                MealPortion mealPortion = iterator.next();
                if (mealPortion.getDurability() == mealDurability) {
                    sumCost += MealType.valueOf(mealPortion.getMealType()).getCost();
                    iterator.remove();
                }
            }
        }

        return sumCost;
    }
}
