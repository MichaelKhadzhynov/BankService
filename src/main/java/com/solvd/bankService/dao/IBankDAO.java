package com.solvd.bankService.dao;

import com.solvd.bankService.models.Bank;

public interface IBankDAO extends IBaseDAO<Bank>{

    public void addBankLogo(long id, String fileName);

}
