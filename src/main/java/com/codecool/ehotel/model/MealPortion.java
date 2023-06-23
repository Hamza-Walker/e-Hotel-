package com.codecool.ehotel.model;

public class MealPortion {
    private String mealType;
    private long timeStamp;
    private MealDurability durability;

    public MealPortion(String mealType, long timeStamp, MealDurability durability) {
        this.mealType = mealType;
        this.timeStamp = timeStamp;
        this.durability = durability;
    }

    public String getMealType() {
        return mealType;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public MealDurability getDurability() {
        return durability;
    }

    @Override
    public String toString() {
        return "MealPortion{" +
                "mealType='" + mealType + '\'' +
                ", timeStamp=" + timeStamp +
                ", durability=" + durability +
                '}';
    }
}
