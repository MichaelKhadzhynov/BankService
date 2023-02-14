package com.solvd.bankService.utils.observer;

public interface Observable {

    public void addObserver(IObserver IObserver);

    public void removeObserver(IObserver IObserver);

    public void notifyObserver();
}
