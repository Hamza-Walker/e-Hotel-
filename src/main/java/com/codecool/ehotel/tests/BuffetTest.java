package com.codecool.ehotel.tests;

import com.codecool.ehotel.model.Buffet;
import com.codecool.ehotel.model.MealDurability;
import com.codecool.ehotel.model.MealPortion;

import java.util.List;

public class BuffetTest {

    public static void main(String[] args) {
        Buffet buffet = new Buffet();

        // Adding meal portions to the buffet
        buffet.addMealPortion("SCRAMBLED_EGGS", new MealPortion("SCRAMBLED_EGGS", System.currentTimeMillis(), MealDurability.SHORT));
        buffet.addMealPortion("SCRAMBLED_EGGS", new MealPortion("SCRAMBLED_EGGS", System.currentTimeMillis(), MealDurability.SHORT));
        buffet.addMealPortion("FRIED_BACON", new MealPortion("FRIED_BACON", System.currentTimeMillis(), MealDurability.SHORT));
        buffet.addMealPortion("PANCAKE", new MealPortion("PANCAKE", System.currentTimeMillis(), MealDurability.SHORT));
        buffet.addMealPortion("PANCAKE", new MealPortion("PANCAKE", System.currentTimeMillis(), MealDurability.SHORT));

        // Retrieving meal portions for a specific meal type
        List<MealPortion> scrambledEggsPortions = buffet.getMealPortions("SCRAMBLED_EGGS");
        System.out.println("Scrambled Eggs Portions: " + scrambledEggsPortions);

        // Retrieving and sorting meal portions by freshness
        List<MealPortion> pancakePortions = buffet.getSortedMealPortions("PANCAKE", true);
        System.out.println("Pancake Portions (Ascending): " + pancakePortions);

        List<MealPortion> friedBaconPortions = buffet.getSortedMealPortions("FRIED_BACON", false);
        System.out.println("Fried Bacon Portions (Descending): " + friedBaconPortions);
    }
}
