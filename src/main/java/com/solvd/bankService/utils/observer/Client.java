package com.solvd.bankService.utils.observer;

import org.apache.log4j.Logger;

import java.util.List;

public class Client implements IObserver {
    private static  final Logger LOGGER = Logger.getLogger(Client.class);

    private final String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(PersonType personType, String news) {
        if (personType.equals(PersonType.CLIENT)) {
            LOGGER.info("Dear client " + name + " this is news update: " + news);
        }
    }
}
