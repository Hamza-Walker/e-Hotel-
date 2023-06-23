package com.codecool.ehotel.service.guest;

import com.codecool.ehotel.model.Guest;

import java.time.LocalDate;
import java.util.Set;

public interface IGuestService {
    Set<Guest> getGuestsForDay(LocalDate date);

}
