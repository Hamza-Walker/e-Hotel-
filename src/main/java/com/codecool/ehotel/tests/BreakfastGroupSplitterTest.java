package com.codecool.ehotel.tests;

import com.codecool.ehotel.groupSplitter.BreakfastGroupSplitter;
import com.codecool.ehotel.model.Guest;

import java.util.List;

import static com.codecool.ehotel.groupSplitter.BreakfastGroupSplitter.NUM_BREAKFAST_CYCLES;
import static com.codecool.ehotel.groupSplitter.BreakfastGroupSplitter.createGuestsForDay;

public class BreakfastGroupSplitterTest {
    public static void main(String[] args) {
        List<Guest> guests = createGuestsForDay();
        BreakfastGroupSplitter splitter = new BreakfastGroupSplitter();
        List<List<Guest>> breakfastCycles = splitter.splitGuestsIntoBreakfastCycles(guests);

        // Print the groups for each breakfast cycle
        for (int i = 0; i < NUM_BREAKFAST_CYCLES; i++) {
            System.out.println("Breakfast Cycle " + (i + 1) + ": " + breakfastCycles.get(i));
        }
    }
}
