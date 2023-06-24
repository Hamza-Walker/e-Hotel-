package com.codecool.ehotel.groupSplitter;

import com.codecool.ehotel.model.Guest;
import com.codecool.ehotel.model.GuestType;
import com.codecool.ehotel.service.guest.GuestGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BreakfastGroupSplitter {
    public static final int NUM_BREAKFAST_CYCLES = 8;

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

    public List<Guest> createGuestsForDay(int totalGuests) {
        List<Guest> guests = new ArrayList<>();
        GuestGenerator guestGenerator = new GuestGenerator();

        for (int i = 0; i < totalGuests; i++) {
            Guest guest = guestGenerator.nextGuest();
            guests.add(guest);
        }

        return guests;
    }
}
