package com.codecool.ehotel.service.buffet;

import com.codecool.ehotel.model.Buffet;
import com.codecool.ehotel.model.MealDurability;

import java.util.Collection;

public interface IBuffetService {
void refillBuffet( Collection<MealRefill> mealRefills);
boolean consumeFreshest(Buffet buffet, String mealType);
double collectWaste(Buffet buffet, MealDurability mealDurability, long timeStamp , String mealType);
}
