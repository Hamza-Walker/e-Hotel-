package com.codecool.ehotel.groupSplitter;

import com.codecool.ehotel.model.Guest;
import com.codecool.ehotel.model.GuestType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BreakfastGroupSplitter {
    public static final int NUM_BREAKFAST_CYCLES = 8;
    public static final int CYCLE_DURATION_MINUTES = 30;

    public static List<Guest> createGuestsForDay() {
        List<Guest> guests = new ArrayList<>();
        Random random = new Random();
        int totalGuests = 20; // Define the total number of guests for the day

        for (int i = 0; i < totalGuests; i++) {
            String guestName = "Guest " + (i + 1);
            int arrivalCycle = random.nextInt(NUM_BREAKFAST_CYCLES) + 1; // Randomly assign a breakfast cycle
            LocalDate checkIn = LocalDate.now();
            LocalDate checkOut = checkIn.plusDays(1); // Assuming guests check out the next day

            Guest guest = new Guest(guestName, GuestType.BUSINESS, checkIn, checkOut);
            guests.add(guest);
        }

        return guests;
    }

    public List<List<Guest>> splitGuestsIntoBreakfastCycles(List<Guest> guests) {
        List<List<Guest>> breakfastCycles = new ArrayList<>(NUM_BREAKFAST_CYCLES);

        for (int i = 0; i < NUM_BREAKFAST_CYCLES; i++) {
            breakfastCycles.add(new ArrayList<>());
        }

        int cycleIndex = 0;
        for (Guest guest : guests) {
            breakfastCycles.get(cycleIndex).add(guest);
            cycleIndex = (cycleIndex + 1) % NUM_BREAKFAST_CYCLES;
        }

        return breakfastCycles;
    }
}
