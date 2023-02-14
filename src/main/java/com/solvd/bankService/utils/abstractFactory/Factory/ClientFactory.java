package com.solvd.bankService.utils.abstractFactory.Factory;

import com.solvd.bankService.utils.abstractFactory.Person.ClientCreate;
import com.solvd.bankService.utils.abstractFactory.Person.IPerson;

public class ClientFactory implements IAbstractFactory {

    @Override
    public IPerson createPerson() {
        return new ClientCreate();
    }
}
