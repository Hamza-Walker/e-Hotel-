package com.codecool.ehotel.service.breakfast;

import com.codecool.ehotel.constants.Constants;
import com.codecool.ehotel.model.*;
import com.codecool.ehotel.service.buffet.BuffetServiceImpl;
import com.codecool.ehotel.service.buffet.MealRefill;

import java.util.*;


public class BreakfastManager {
    private Buffet buffet;
    private List<List<Guest>> breakfastCycles;
    private BuffetServiceImpl buffetService;
    private int unhappyGuests;
    private double totalCost;
    private double totalProfit;



    public BreakfastManager(List<List<Guest>> breakfastCycles) {
        this.breakfastCycles = breakfastCycles;
        this.buffet = new Buffet();
        this.buffetService = new BuffetServiceImpl(buffet);
        this.unhappyGuests = 0;
        this.totalCost=0;
        this.totalProfit = 0;

    }

    public void serve() {
        for (int cycle = 0; cycle < breakfastCycles.size(); cycle++) {
            List<Guest> guests = breakfastCycles.get(cycle);

            // Phase 1: Refill buffet supply
            refillBuffet();
            delay(2000); // Delay for 2 seconds (2000 milliseconds)

            // Phase 2: Consume breakfast
            consumeBreakfast(guests);
            delay(1000); // Delay for 1 second (1000 milliseconds)


            // Print buffet status after each cycle
            System.out.println("Buffet Status (Cycle " + (cycle) + "):");
            System.out.println(buffet);
            delay(1000); // Delay for 1 second (1000 milliseconds)

            // Phase 3: measure statistics and Discard old meals
            double wasteCost = discardOldMeals(cycle);
            delay(1500); // Delay for 1.5 seconds (1500 milliseconds)
            logTotalCost(cycle);
            logTotalProfit(cycle, wasteCost);
            System.out.println("Number of Unhappy Guests: " + getUnhappyGuests());
        }
    }

    private void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void refillBuffet() {
        List<MealRefill> mealRefills = generateMealRefills(); // Generate meal refills for the buffet
        buffetService.refillBuffet(mealRefills);
    }

    private List<MealRefill> generateMealRefills() {
        List<MealRefill> mealRefills = new ArrayList<>();

        // Generate meal refills for the buffet
        for (MealType mealType : MealType.values()) {
            int refillAmount = generateRandomRefillAmount();
            MealRefill mealRefill = new MealRefill(mealType.toString(), refillAmount);
            mealRefills.add(mealRefill);
        }

        return mealRefills;
    }
    private void logTotalProfit(int cycle, double wasteCost) {
        double totalCycleProfit = totalCost - wasteCost;
        System.out.println("Total Profit for Cycle " + cycle + ": " + totalCycleProfit);
        totalProfit += totalCycleProfit; // Increment the total profit
    }
    private int generateRandomRefillAmount() {
        return Constants.RANDOM.nextInt(6); // Generates a number from 0 to 5
    }

    private void consumeBreakfast(List<Guest> guests) {
        for (Guest guest : guests) {
            MealType mealPreference = getRandomMealPreference(guest);

            if (shouldFindMeal()) {
                boolean isMealAvailable = buffetService.consumeFreshest(buffet, String.valueOf(mealPreference));

                if (isMealAvailable) {
                    double mealCost = calculateMealCost(mealPreference);
                    totalCost += mealCost; // Increment the total cost
                    System.out.println(guest.name() + " had " + mealPreference + " (Cost: " + mealCost + ")");
                } else {
                    System.out.println(guest.name() + " couldn't find " + mealPreference + " and went hungry");
                    unhappyGuests++; // Increment the number of unhappy guests
                }
            } else {
                System.out.println(guest.name() + " skipped breakfast today");
            }
        }
    }
    private void logTotalCost(int cycle) {
        System.out.println("Total Cost for Cycle " + cycle + ": " + totalCost);
    }

    private double calculateMealCost(MealType mealType) {
        return mealType.getCost();
    }


    private boolean shouldFindMeal() {
        //  75% chance of finding a meal
        return Constants.RANDOM.nextDouble() <= 0.75;
    }

    private MealType getRandomMealPreference(Guest guest) {
        List<MealType> mealPreferences = guest.guestType().getMealPreferences();
        Random random = new Random();
        int index = random.nextInt(mealPreferences.size());
        return mealPreferences.get(index);
    }

    private double discardOldMeals(int cycle) {
        double wasteCost = buffetService.collectWaste(buffet, MealDurability.SHORT);
        System.out.println(" Total waste cost: " + wasteCost);

        return wasteCost;
    }



    public int getUnhappyGuests() {
        return unhappyGuests;
    }

    public double getTotalProfit() {
        return totalProfit;
    }
}
