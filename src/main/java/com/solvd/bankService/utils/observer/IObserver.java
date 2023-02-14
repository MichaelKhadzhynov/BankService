package com.solvd.bankService.utils.observer;

import java.util.List;

public interface IObserver {

    public void handleEvent(PersonType personType, String transactions);
}
