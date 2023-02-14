package com.solvd.bankService.utils.observer;

import java.util.ArrayList;
import java.util.List;

public class BankNews implements Observable {

    private String news;
    private PersonType personType;
    private final List<IObserver> observers = new ArrayList<>();

    public void addNews(PersonType personType, String news){
        this.news = news;
        this.personType = personType;
        notifyObserver();

    }

    @Override
    public void addObserver(IObserver IObserver) {
        this.observers.add(IObserver);
    }

    @Override
    public void removeObserver(IObserver IObserver) {
        this.observers.remove(IObserver);
    }

    @Override
    public void notifyObserver() {
        for (IObserver o : observers){
            o.handleEvent(personType, news);
        }
    }
}
