package com.codecool.ehotel.service.buffet;

import com.codecool.ehotel.model.Buffet;
import com.codecool.ehotel.model.MealDurability;
import com.codecool.ehotel.model.MealRefill;

import java.util.Collection;
import java.util.List;

public interface BuffetServiceInterface {
void refillBuffet( List<MealRefill> mealRefills);
boolean consumeFreshest(Buffet buffet, String mealType);
double collectWaste(Buffet buffet, MealDurability mealDurability);
}
