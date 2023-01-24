package com.solvd.bankService.dao.mySQL.daoFactory;

import com.solvd.bankService.dao.*;
import com.solvd.bankService.dao.mySQL.*;

public class DAOFactoryMySQL implements IDAOFactory{
    @Override
    public IAccountDetailsDAO getAccountDetailsDAO() {
        return AccountDetailsDAO.getInstance();
    }

    @Override
    public IAddressDAO getAddressDAO() {
        return AddressDAO.getInstance();
    }

    @Override
    public IAlterTableDAO getAlterTableDAO() {
        return AlterTableDAO.getInstance();
    }

    @Override
    public IBankAccountDAO getBankAccountDAO() {
        return BankAccountDAO.getInstance();
    }

    @Override
    public IBankDAO getBankDAO() {
        return BankDAO.getInstance();
    }

    @Override
    public ICashTransactionDepartmentDAO getCashTransactionDepartmentDAO() {
        return CashTransactionDepartmentDAO.getInstance();
    }

    @Override
    public IClientsDAO getClientDAO() {
        return ClientsDAO.getInstance();
    }

    @Override
    public ICreditCardDAO getCreditCardDAO() {
        return CreditCardDAO.getInstance();
    }

    @Override
    public IDepositDepartmentDAO getDepositDepartmentDAO() {
        return DepositDepartmentDAO.getInstance();
    }

    @Override
    public IEmployeesDAO getEmployeesDao() {
        return EmployeesDao.getInstance();
    }

    @Override
    public IPersonsDAO getPersonsDAO() {
        return PersonsDAO.getInstance();
    }
}
