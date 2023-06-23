package com.codecool.ehotel.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buffet {
    private Map<String, List<MealPortion>> meals;

    public Buffet() {
        this.meals = new HashMap<>();
    }

    public void addMealPortion(String mealType, MealPortion mealPortion) {
        meals.computeIfAbsent(mealType, key -> new ArrayList<>()).add(mealPortion);
    }

    public List<MealPortion> getMealPortions(String mealType) {
        return meals.getOrDefault(mealType, new ArrayList<>());
    }

    public List<MealPortion> getSortedMealPortions(String mealType, boolean ascending) {
        List<MealPortion> mealPortions = getMealPortions(mealType);
        mealPortions.sort((p1, p2) -> ascending ? Long.compare(p1.getTimeStamp(), p2.getTimeStamp())
                : Long.compare(p2.getTimeStamp(), p1.getTimeStamp()));
        return mealPortions;
    }

    public void decrementItemCount(String mealType) {
        List<MealPortion> mealPortions = meals.get(mealType);
        if (mealPortions != null && !mealPortions.isEmpty()) {
            mealPortions.remove(0); // Remove the first meal portion to decrement the count
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Buffet{");
        for (String mealType : meals.keySet()) {
            int quantity = meals.get(mealType).size();
            sb.append(mealType).append(" (").append(quantity).append("), ");
        }
        if (!meals.isEmpty()) {
            sb.setLength(sb.length() - 2); // Remove the trailing comma and space
        }
        sb.append("}");
        return sb.toString();
    }
}
