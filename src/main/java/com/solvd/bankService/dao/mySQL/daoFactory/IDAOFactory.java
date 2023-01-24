package com.solvd.bankService.dao.mySQL.daoFactory;

import com.solvd.bankService.dao.* ;


public interface IDAOFactory {

    IAccountDetailsDAO getAccountDetailsDAO();
    IAddressDAO getAddressDAO();
    IAlterTableDAO getAlterTableDAO();
    IBankAccountDAO getBankAccountDAO();
    IBankDAO getBankDAO();
    ICashTransactionDepartmentDAO getCashTransactionDepartmentDAO();
    IClientsDAO getClientDAO();
    ICreditCardDAO getCreditCardDAO();
    IDepositDepartmentDAO getDepositDepartmentDAO();
    IEmployeesDAO getEmployeesDao();
    IPersonsDAO getPersonsDAO();
}
