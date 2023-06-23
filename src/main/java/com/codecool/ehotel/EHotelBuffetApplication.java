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
        ILogger logger = new ConsoleLogger();

        // Initialize services
        Constants.GUEST_NAMES.forEach(System.out::println);
        // Generate guests for the season

        GuestGenerator guestGenerator = new GuestGenerator();

        Guest guest = guestGenerator.nextGuest();
       // System.out.println(guest);

        IGuestService guestService = new GuestService(guestGenerator, 1000);
        //System.out.println(guestService.getGuestsForDay(LocalDate.now().plusDays(2)));
        
        // Run breakfast buffet
    }
}
