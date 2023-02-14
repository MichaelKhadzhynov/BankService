package com.solvd.bankService.utils.observer;

import org.apache.log4j.Logger;

public class Employee implements IObserver{
    private static  final Logger LOGGER = Logger.getLogger(Client.class);

    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(PersonType personType, String news) {
        if (personType.equals(PersonType.EMPLOYEE)) {
            LOGGER.info("Dear employee " + name + " this is news update: " + news);
        }
    }
}
