package com.solvd.bankService.utils.abstractFactory.Factory;

import com.solvd.bankService.utils.abstractFactory.Person.EmployeeCreate;
import com.solvd.bankService.utils.abstractFactory.Person.IPerson;

public class EmployeeFactory implements IAbstractFactory {
    @Override
    public IPerson createPerson() {
        return new EmployeeCreate();
    }
}
