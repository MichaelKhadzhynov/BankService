package com.solvd.bankService.dao;

import com.solvd.bankService.models.CreditCard;

import java.util.List;

public interface ICreditCardDAO extends IBaseDAO<CreditCard>{

    public List<CreditCard> getCreditCardList();
}
