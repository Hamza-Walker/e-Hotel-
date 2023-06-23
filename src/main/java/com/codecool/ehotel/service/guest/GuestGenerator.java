package com.codecool.ehotel.service.guest;

import com.codecool.ehotel.constants.Constants;
import com.codecool.ehotel.model.Guest;
import com.codecool.ehotel.model.GuestType;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class GuestGenerator implements IGuestProvider{
    @Override
    public  Guest nextGuest() {
        int guestNameIndex = Constants.RANDOM.nextInt(Constants.GUEST_NAMES.size());
        String guestName = Constants.GUEST_NAMES.get(guestNameIndex);
        GuestType guestType = GuestType.values()[Constants.RANDOM.nextInt(GuestType.values().length)];
        LocalDate checkIn = generateNewDate();
        LocalDate checkOut = checkIn.plusDays(Constants.RANDOM.nextInt(1, Constants.MAX_STAY));

        return new Guest(guestName, guestType, checkIn, checkOut);
    }

    private LocalDate generateNewDate() {
        LocalDate today = LocalDate.now();
        LocalDate nextYear = today.plusYears(1);

        long minDay = today.toEpochDay();
        long maxDay = nextYear.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        return randomDate;
    }
}
