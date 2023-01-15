package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.IBankDAO;
import com.solvd.bankService.models.Bank;

public class BankDAO extends MySqlDAO implements IBankDAO {

    private static final BankDAO INSTANCE = new BankDAO();




    public static BankDAO getInstance(){
        return INSTANCE;
    }

    @Override
    public Bank getEntityById(long id) {
        return null;
    }

    @Override
    public void updateEntity(Bank entity) {

    }

    @Override
    public Bank createEntity(Bank entity) {
        return null;
    }

    @Override
    public void removeEntity(long id) {

    }
}
