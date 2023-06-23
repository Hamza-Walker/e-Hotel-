package com.codecool.ehotel.service.buffet;

import com.codecool.ehotel.model.Buffet;
import com.codecool.ehotel.model.MealDurability;
import com.codecool.ehotel.model.MealPortion;
import com.codecool.ehotel.model.MealType;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BuffetServiceImpl implements IBuffetService {
    private Buffet buffet;

    public BuffetServiceImpl(Buffet buffet) {
        this.buffet = buffet;
    }

    @Override
    public void refillBuffet(Collection<MealRefill> mealRefills) {
        for (MealRefill mealRefill : mealRefills) {
            MealType mealType = MealType.valueOf(mealRefill.mealType());

            for (int i = 0; i < mealRefill.amount(); i++) {
                long currentTimeStamp = System.currentTimeMillis();
                MealPortion mealPortion = new MealPortion(mealType.toString(), currentTimeStamp, MealDurability.LONG);
                buffet.addMealPortion(mealType.toString(), mealPortion);
            }
        }
    }

    @Override
    public boolean consumeFreshest(Buffet buffet, String mealType) {
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


    @Override
    public double collectWaste(Buffet buffet, MealDurability mealDurability, long timeStamp, String mealType) {
        List<MealPortion> mealPortions = buffet.getMealPortions(mealType);
        double sumCost = 0.0;

        Iterator<MealPortion> iterator = mealPortions.iterator();
        while (iterator.hasNext()) {
            MealPortion mealPortion = iterator.next();
            System.out.println("Comparing durability: " + mealPortion.getDurability() + " with " + mealDurability);
            if (mealPortion.getDurability() == mealDurability && mealPortion.getTimeStamp() < timeStamp) {
                System.out.println("Removing meal portion: " + mealPortion);
                sumCost += MealType.valueOf(mealPortion.getMealType()).getCost();
                iterator.remove();
            }
        }

        return sumCost;
    }


}
