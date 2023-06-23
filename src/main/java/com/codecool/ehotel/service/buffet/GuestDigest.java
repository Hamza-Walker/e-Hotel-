package com.codecool.ehotel.service.buffet;

import com.codecool.ehotel.model.Buffet;
import com.codecool.ehotel.model.MealPortion;

import java.util.List;

public class GuestDigest {
    public static boolean consumeFreshest(Buffet buffet, String mealType) {
        List<MealPortion> mealPortions = buffet.getMealPortions(mealType);

        if (mealPortions.isEmpty()) {
            return false;
        }

        MealPortion freshestPortion = mealPortions.get(0);
        int freshestIndex = 0;

        for (int i = 1; i < mealPortions.size(); i++) {
            MealPortion currentPortion = mealPortions.get(i);
            if (currentPortion.getTimeStamp() > freshestPortion.getTimeStamp()) {
                freshestPortion = currentPortion;
                freshestIndex = i;
            }
        }

        mealPortions.remove(freshestIndex);

        // Decrement the number of items in the buffet manually
        buffet.decrementItemCount(mealType);

        return true;
    }
}
