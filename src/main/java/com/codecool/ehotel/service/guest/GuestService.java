package com.codecool.ehotel.service.guest;

import com.codecool.ehotel.model.Guest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GuestService implements IGuestService{
    private final List<Guest> guests;

    public GuestService(IGuestProvider guestProvider, int guestAmount) {
        this.guests = new ArrayList<>();
        for (int i = 0; i < guestAmount; i++) {
            guests.add(guestProvider.nextGuest());
        }
    }

    public Set<Guest> getGuestsForDay(LocalDate date) {
        return guests.stream()
                .filter(guest -> isBetween(date, guest.checkIn(), guest.checkOut()))
                .collect(Collectors.toSet());
    }

    private boolean isBetween(LocalDate current, LocalDate start, LocalDate end) {


        return current.isAfter(start) && current.isBefore(end);
    }

    @Override
    public String toString() {
        String message = "";

        for (Guest guest : guests) {
            message += guest + "\n";
        }

        return message;
    }
}
