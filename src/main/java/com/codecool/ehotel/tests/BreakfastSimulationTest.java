package com.codecool.ehotel.tests;

import com.codecool.ehotel.constants.Constants;
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
        List<List<Guest>> breakfastCycles = new ArrayList<>();

        GuestGenerator guestGenerator = new GuestGenerator(); // Create an instance of GuestGenerator

        for (int i = 0; i < 30; i++) {
            int numGuests = Constants.RANDOM.nextInt(50) + 1; // Generate a random number of guests from 1 to 5
            List<Guest> cycle = new ArrayList<>();

            for (int j = 0; j < numGuests; j++) {
                cycle.add(guestGenerator.nextGuest());
            }
            breakfastCycles.add(cycle);
        }

        return breakfastCycles;
    }



}
