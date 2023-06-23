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
       return WasteCollector.collectWaste(buffet,mealDurability);
    }

}
