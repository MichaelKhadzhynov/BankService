package com.solvd.bankService.utils.abstractFactory.Factory;

import com.solvd.bankService.utils.abstractFactory.Person.IPerson;

public class PersonFactory {
    private IPerson persons;

    public PersonFactory(IAbstractFactory factory){
        persons = factory.createPerson();
    }

    public void create(Object person){
        persons.create(person);
    }
}
