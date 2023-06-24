package com.codecool.ehotel.tests;

import com.codecool.ehotel.groupSplitter.BreakfastGroupSplitter;
import com.codecool.ehotel.model.Guest;

import java.util.List;

public class BreakfastGroupSplitterTest {
    public static void main(String[] args) {
        int totalGuests = 20; // Define the total number of guests for the day

        BreakfastGroupSplitter splitter = new BreakfastGroupSplitter();
        List<Guest> guests = splitter.createGuestsForDay(totalGuests);
        List<List<Guest>> breakfastCycles = splitter.splitGuestsIntoBreakfastCycles(guests);

        // Print the groups for each breakfast cycle
        for (int i = 0; i < breakfastCycles.size(); i++) {
            System.out.println("Breakfast Cycle " + (i + 1) + ": " + breakfastCycles.get(i));
        }
    }
}
