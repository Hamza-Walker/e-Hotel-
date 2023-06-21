package com.codecool.ehotel;

import com.codecool.ehotel.constants.Constants;
import com.codecool.ehotel.model.Guest;
import com.codecool.ehotel.service.guest.GuestGenerator;
import com.codecool.ehotel.service.guest.GuestService;
import com.codecool.ehotel.service.guest.IGuestProvider;
import com.codecool.ehotel.service.guest.IGuestService;
import com.codecool.ehotel.service.logger.ConsoleLogger;
import com.codecool.ehotel.service.logger.ILogger;

import java.time.LocalDate;

public class EHotelBuffetApplication {

    public static void main(String[] args) {
        GuestGenerator guestGenerator = new GuestGenerator();
        Guest guest = guestGenerator.nextGuest();

        IGuestService guestService = new GuestService(guestGenerator, 1000);
        System.out.println(guestService.getGuestsForDay(LocalDate.now().plusDays(2)));
    }
}
