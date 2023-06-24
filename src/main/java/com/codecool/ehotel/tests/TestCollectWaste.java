package com.codecool.ehotel.tests;

import com.codecool.ehotel.model.Buffet;
import com.codecool.ehotel.model.MealDurability;
import com.codecool.ehotel.model.MealPortion;
import com.codecool.ehotel.service.buffet.BuffetServiceImplementation;
import com.codecool.ehotel.service.buffet.BuffetServiceInterface;

public class TestCollectWaste {
    public static void main(String[] args) {
        // Create a buffet and add meal portions
        Buffet buffet = new Buffet();
        buffet.addMealPortion("PANCAKE", new MealPortion("PANCAKE", System.currentTimeMillis() - 1000, MealDurability.SHORT));
        buffet.addMealPortion("PANCAKE", new MealPortion("PANCAKE", System.currentTimeMillis() - 2000, MealDurability.LONG));
        buffet.addMealPortion("PANCAKE", new MealPortion("PANCAKE", System.currentTimeMillis() - 3000, MealDurability.SHORT));
        buffet.addMealPortion("PANCAKE", new MealPortion("PANCAKE", System.currentTimeMillis() - 4000, MealDurability.MEDIUM));

        BuffetServiceInterface buffetService = new BuffetServiceImplementation(buffet);

        // Collect waste with a timestamp of 1500 milliseconds and meal durability of SHORT
        double wasteCost = buffetService.collectWaste(buffet, MealDurability.SHORT);

        // Log the results
        System.out.println("Waste cost: " + wasteCost);
        System.out.println("Remaining meal portions: " + buffet.getMealPortions("PANCAKE").size());
    }
}
