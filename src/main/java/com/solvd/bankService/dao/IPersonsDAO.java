package com.solvd.bankService.dao;

import com.solvd.bankService.models.Persons;

import java.util.List;

public interface IPersonsDAO extends IBaseDAO<Persons>{
    public List<Persons> getPersonsList();
}
