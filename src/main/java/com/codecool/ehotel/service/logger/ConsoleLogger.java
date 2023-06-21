package com.codecool.ehotel.service.logger;

import java.time.LocalDate;
import java.util.Date;

public class ConsoleLogger implements ILogger {
    @Override
    public void logInfo(String message) {
        System.out.println(LocalDate.now() + " INFO: " + message);
    }
    @Override
    public void logError(String message) {
        System.out.println(LocalDate.now() + " ERROR: " + message);
    }
}
