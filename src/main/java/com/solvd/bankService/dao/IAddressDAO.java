package com.solvd.bankService.dao;

import com.solvd.bankService.models.Address;

import java.util.List;

public interface IAddressDAO extends IBaseDAO<Address>{
    public List<Address> getAddressList();
}
