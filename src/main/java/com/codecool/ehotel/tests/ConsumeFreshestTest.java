package com.codecool.ehotel.tests;

import com.codecool.ehotel.model.Buffet;
import com.codecool.ehotel.model.MealDurability;
import com.codecool.ehotel.model.MealPortion;
import com.codecool.ehotel.service.buffet.BuffetServiceInterface;
import com.codecool.ehotel.service.buffet.BuffetServiceImpl;

public class ConsumeFreshestTest {

    public static void main(String[] args) {
        Buffet buffet = new Buffet();
        BuffetServiceInterface buffetService = new BuffetServiceImpl(buffet);

        // Adding meal portions to the buffet
        buffet.addMealPortion("SCRAMBLED_EGGS", new MealPortion("SCRAMBLED_EGGS", System.currentTimeMillis(), MealDurability.SHORT));
        buffet.addMealPortion("FRIED_BACON", new MealPortion("FRIED_BACON", System.currentTimeMillis(), MealDurability.SHORT));
        buffet.addMealPortion("PANCAKE", new MealPortion("PANCAKE", System.currentTimeMillis(), MealDurability.SHORT));
        buffet.addMealPortion("PANCAKE", new MealPortion("PANCAKE", System.currentTimeMillis(), MealDurability.SHORT));

        // Consume the freshest portion of SCRAMBLED_EGGS
        boolean success = buffetService.consumeFreshest(buffet, "SCRAMBLED_EGGS");
        if (success) {
            System.out.println("Successfully consumed the freshest portion of SCRAMBLED_EGGS.");
        } else {
            System.out.println("Failed to consume the freshest portion of SCRAMBLED_EGGS.");
        }

        // Consume the freshest portion of PANCAKE
        success = buffetService.consumeFreshest(buffet, "PANCAKE");
        if (success) {
            System.out.println("Successfully consumed the freshest portion of PANCAKE.");
        } else {
            System.out.println("Failed to consume the freshest portion of PANCAKE.");
        }

        // Consume the freshest portion of FRIED_BACON
        success = buffetService.consumeFreshest(buffet, "FRIED_BACON");
        if (success) {
            System.out.println("Successfully consumed the freshest portion of FRIED_BACON.");
        } else {
            System.out.println("Failed to consume the freshest portion of FRIED_BACON.");
        }

        // Try to consume the freshest portion of OMELETTE (not available in the buffet)
        success = buffetService.consumeFreshest(buffet, "OMELETTE");
        if (success) {
            System.out.println("Successfully consumed the freshest portion of OMELETTE.");
        } else {
            System.out.println("Failed to consume the freshest portion of OMELETTE.");
        }
    }
}
