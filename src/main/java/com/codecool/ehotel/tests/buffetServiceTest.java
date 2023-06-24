package com.codecool.ehotel.tests;

import com.codecool.ehotel.model.Buffet;
import com.codecool.ehotel.service.buffet.BuffetServiceImplementation;
import com.codecool.ehotel.model.MealRefill;

import java.util.ArrayList;
import java.util.List;

 class BuffetServiceTest {

    public static void main(String[] args) {
        // Create a buffet instance
        Buffet buffet = new Buffet();

        // Create a list of meal refills
        List<MealRefill> mealRefills = new ArrayList<>();
        mealRefills.add(new MealRefill("SCRAMBLED_EGGS", 5));
        mealRefills.add(new MealRefill("PANCAKE", 3));
        mealRefills.add(new MealRefill("FRIED_BACON", 2));

        // Create an instance of the buffet service
        BuffetServiceImplementation buffetService = new BuffetServiceImplementation(buffet);

        // Refill the buffet with the specified meal refills
        buffetService.refillBuffet( mealRefills);

        // Print the meal portions in the buffet
        System.out.println("Meal Portions in Buffet:");
        System.out.println(buffet.getMealPortions("SCRAMBLED_EGGS"));
    }
}
