package com.solvd.bankService.dao;

import com.solvd.bankService.models.Clients;

import java.util.List;

public interface IClientsDAO extends IBaseDAO<Clients>{
    public List<Clients> getClientsList();
}
