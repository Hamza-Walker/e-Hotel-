package com.codecool.ehotel.service.buffet;

import com.codecool.ehotel.model.Buffet;
import com.codecool.ehotel.model.MealDurability;
import com.codecool.ehotel.model.MealPortion;
import com.codecool.ehotel.model.MealType;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BuffetServiceImpl implements BuffetServiceInterface {
    private Buffet buffet;

    public BuffetServiceImpl(Buffet buffet) {
        this.buffet = buffet;
    }

    @Override
    public void refillBuffet(Collection<MealRefill> mealRefills) {
        BuffetRefiller.refillBuffet(buffet, mealRefills);
    }

    @Override
    public boolean consumeFreshest(Buffet buffet, String mealType) {
       return GuestDigest.consumeFreshest(buffet, mealType);
    }

    @Override
    public double collectWaste(Buffet buffet, MealDurability mealDurability) {
        List<List<MealPortion>> allMealPortions = buffet.getAllMealPortions();
        double sumCost = 0.0;

        for (List<MealPortion> mealPortions : allMealPortions) {
            Iterator<MealPortion> iterator = mealPortions.iterator();
            while (iterator.hasNext()) {
                MealPortion mealPortion = iterator.next();
                System.out.println("Comparing durability: " + mealPortion.getDurability() + " with " + mealDurability);
                if (mealPortion.getDurability() == mealDurability) {
                    System.out.println("Removing meal portion: " + mealPortion);
                    sumCost += MealType.valueOf(mealPortion.getMealType()).getCost();
                    iterator.remove();
                }
            }
        }

        return sumCost;
    }




}
