package com.codecool.ehotel.tests;

import com.codecool.ehotel.constants.Constants;
import com.codecool.ehotel.groupSplitter.BreakfastGroupSplitter;
import com.codecool.ehotel.model.Guest;
import com.codecool.ehotel.service.breakfast.BreakfastManager;
import com.codecool.ehotel.service.guest.GuestGenerator;

import java.util.ArrayList;
import java.util.List;

public class BreakfastSimulationTest {
    public static void main(String[] args) {
        // Create a list of breakfast cycles with guests
        List<List<Guest>> breakfastCycles = createBreakfastCycles();

        // Create and initialize the BreakfastManager
        BreakfastManager breakfastManager = new BreakfastManager(breakfastCycles);

        // Start the breakfast simulation
        breakfastManager.serve();
    }

    private static List<List<Guest>> createBreakfastCycles() {
        List<Guest> guests = new ArrayList<>();
        GuestGenerator guestGenerator = new GuestGenerator();

        for (int i = 0; i < 30; i++) {
            guests.add(guestGenerator.nextGuest());
        }

        BreakfastGroupSplitter groupSplitter = new BreakfastGroupSplitter();
        List<List<Guest>> breakfastCycles = groupSplitter.splitGuestsIntoBreakfastCycles(guests);

        return breakfastCycles;
    }




}
