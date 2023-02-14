package com.solvd.bankService.utils.abstractFactory;

import com.solvd.bankService.utils.abstractFactory.Factory.ClientFactory;
import com.solvd.bankService.utils.abstractFactory.Factory.EmployeeFactory;
import com.solvd.bankService.utils.abstractFactory.Factory.IAbstractFactory;
import com.solvd.bankService.utils.abstractFactory.Factory.PersonFactory;

public class FactoryConfig {

    public static PersonFactory configureFactory(PersonsType personsType){
        IAbstractFactory factory;
        PersonFactory app;

        if(personsType.equals(PersonsType.CLIENT)){
            factory = new ClientFactory();
        } else {
            factory = new EmployeeFactory();
        }
        app = new PersonFactory(factory);
        return app;
    }
}
