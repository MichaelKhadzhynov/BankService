package com.solvd.bankService.utils.abstractFactory;

public enum PersonsType {
    CLIENT("client"),
    EMPLOYEE("employee");

    public final String person;

    PersonsType(String person) {
        this.person = person;
    }

    public String getPerson() {
        return person;
    }
}
