package com.solvd.bankService.utils.abstractFactory.Factory;

import com.solvd.bankService.utils.abstractFactory.Person.IPerson;

public interface IAbstractFactory {

    IPerson createPerson();
}
