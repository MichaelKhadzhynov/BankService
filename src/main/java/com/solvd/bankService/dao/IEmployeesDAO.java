package com.solvd.bankService.dao;

import com.solvd.bankService.models.Employees;

import java.util.List;

public interface IEmployeesDAO extends IBaseDAO<Employees>{
    public List<Employees> getEmployeesList();
}
