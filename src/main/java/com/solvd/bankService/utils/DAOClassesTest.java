package com.solvd.bankService.utils;

import com.solvd.bankService.dao.mySQL.DepositDepartmentDAO;
import com.solvd.bankService.dao.mySQL.EmployeesDao;
import com.solvd.bankService.models.DepositDepartment;
import com.solvd.bankService.models.Employees;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DAOClassesTest {

    private final static Logger LOGGER = Logger.getLogger(DAOClassesTest.class);

    public static void DAOTesting(){
        /**
         DepositDepartment
         **/

//        DepositDepartment entityById = DepositDepartmentDAO.getInstance().getEntityById(2);
//        LOGGER.info(entityById);

//        DepositDepartment depositDepartment = new DepositDepartment();
//        depositDepartment.setClientId(ClientsDAO.getInstance().getEntityById(1));
//        depositDepartment.setCash(2000);
//        depositDepartment.setDepositPercent(5);
//        depositDepartment.setEmployeeId(EmployeesDao.getInstance().getEntityById(3));
//        DepositDepartmentDAO.getInstance().createEntity(depositDepartment);

//        DepositDepartment entityById = DepositDepartmentDAO.getInstance().getEntityById(4);
//        entityById.setEmployeeId(EmployeesDao.getInstance().getEntityById(3));
//        DepositDepartmentDAO.getInstance().updateEntity(entityById);

//        DepositDepartmentDAO.getInstance().removeEntity(4);

        /**
         CreditCard
         **/
//        CreditCard entityById = CreditCardDAO.getInstance().getEntityById(1);
//        LOGGER.info(entityById);

//        CreditCard creditCard = new CreditCard();
//        creditCard.setCardNumber(1234567890L);
//        creditCard.setExpiredDate(Date.valueOf("2026-08-12"));
//        creditCard.setCvv(321);
//        creditCard.setClientsId(ClientsDAO.getInstance().getEntityById(1));
//        creditCard.setBankAccountId(BankAccountDAO.getInstance().getEntityById(2));
//        CreditCardDAO.getInstance().createEntity(creditCard);

//        CreditCard entityById = CreditCardDAO.getInstance().getEntityById(13);
//        entityById.setCardNumber(Long.valueOf(CreditCardDAO.getInstance()
//                                                      .getEntityById(13).getCardNumber() + "" + 123456L));
//        CreditCardDAO.getInstance().updateEntity(entityById);

//        CreditCardDAO.getInstance().removeEntity(12);

        /**
         Clients
         **/
//        Clients entityById = ClientsDAO.getInstance().getEntityById(2);
//        LOGGER.info(entityById);

//        Clients clients = new Clients();
//        clients.setPersonId(PersonsDAO.getInstance().getEntityById(1));
//        clients.setClientType("Legal entity");
//        ClientsDAO.getInstance().createEntity(clients);

//        Clients clients = ClientsDAO.getInstance().getEntityById(12);
//        clients.setClientType("Physical person");
//        ClientsDAO.getInstance().updateEntity(clients);

//        ClientsDAO.getInstance().removeEntity(11);


        /**
         Employees
         **/
//        List<Employees> employees = new ArrayList<>();
//        for(long i=1; i<6; i++) {
//            Employees entityById = EmployeesDao.getInstance().getEntityById(i);
//            employees.add(entityById);
//        }
//        LOGGER.info(employees);
//
//        Employees employees = new Employees();
//        employees.setBankId(BankDAO.getInstance().getEntityById(1));
//        employees.setPersonId(PersonsDAO.getInstance().getEntityById(4));
//        employees.setPosition("Admin");
//        employees.setDepartment("Administration");
//        employees.setJobExperience("Low");
//        employees.setEducation("Bachelor");
//        employees.setSalary(500);
//        EmployeesDao.getInstance().createEntity(employees);

//        Employees entityById = EmployeesDao.getInstance().getEntityById(6);
//        entityById.setSalary(550);
//        EmployeesDao.getInstance().updateEntity(entityById);

//        EmployeesDao.getInstance().removeEntity(6);


        /**
         CashTransactionDepartment
         **/
//        CashTransactionDepartment cashTransactionDepartment = CashTransactionDepartmentDAO
//                .getInstance().getEntityById(1);
//        LOGGER.info(cashTransactionDepartment);

//        CashTransactionDepartment cashTransactionDepartment = new CashTransactionDepartment();
//        cashTransactionDepartment.setCashIn(3211);
//        cashTransactionDepartment.setCashOut(3451);
//        cashTransactionDepartment.setEmployeeId(EmployeesDao.getInstance().getEntityById(3));
//        CashTransactionDepartmentDAO.getInstance().createEntity(cashTransactionDepartment);

//        CashTransactionDepartment entityById = CashTransactionDepartmentDAO.getInstance().getEntityById(4);
//        entityById.setCashOut(4000);
//        CashTransactionDepartmentDAO.getInstance().updateEntity(entityById);

//        CashTransactionDepartmentDAO.getInstance().removeEntity(5);


        /**
         Bank
         **/

//        Bank bank = BankDAO.getInstance().getEntityById(1);
//        LOGGER.info(bank);

//        Address address  = new Address();
//        address.setId(1L);
//        Bank bank = new Bank();
//        bank.setBankNumber(4);
//        bank.setAddressId(address);
//        BankDAO.getInstance().createEntity(bank);

//        Bank bank = BankDAO.getInstance().getEntityById(5);
//        bank.setBankNumber(6);
//        BankDAO.getInstance().updateEntity(bank);

//        BankDAO.getInstance().removeEntity(5);


        /**
         BankAccount
         **/
//        BankAccount bankAccount = BankAccountDAO.getInstance().getEntityById(1);
//        LOGGER.info(bankAccount);


//        AccountDetails accountDetails = new AccountDetails();
//        accountDetails.setId(4L);
//
//        BankAccount bankAccount = new BankAccount();
//        bankAccount.setAccountNumber(12345678L);
//        bankAccount.setBalance(1354);
//        bankAccount.setAccountType("personal");
//        bankAccount.setAccountDetailsId(accountDetails);
//        BankAccountDAO.getInstance().createEntity(bankAccount);

//        BankAccount bankAccount = BankAccountDAO.getInstance().getEntityById(9);
//        bankAccount.setAccountNumber(645325634678L);
//        BankAccountDAO.getInstance().updateEntity(bankAccount);

//        BankAccountDAO.getInstance().removeEntity(9);

        /**
         AccountDetailsDAO
         **/

//        AccountDetails accountDetails = AccountDetailsDAO.getInstance().getEntityById(4);
//        LOGGER.info(accountDetails);

//        AccountDetailsDAO accountDetailsDAO = AccountDetailsDAO.getInstance();
//        AccountDetails accountDetails = new AccountDetails();
//        accountDetails.setIban(3632857917094142333L);
//        accountDetailsDAO.updateEntity(accountDetails);

//        Bank bank = new Bank();
//        bank.setId(3L);
//        AccountDetails accountDetails = new AccountDetails();
//        accountDetails.setIban(123L);
//        accountDetails.setBankId(bank);
//        AccountDetailsDAO.getInstance().createEntity(accountDetails);

//        AccountDetailsDAO.getInstance().removeEntity(12);

        /**
         AddressDAO
         **/

//        AddressDAO instance = AddressDAO.getInstance();
//        Address address = new Address();
//        address.setId(4L);
//        address.setCountry("Ukraine");
//        address.setCity("Lviv");
//        address.setHomeAddress("wr23r23r");
//        address.setPostalCode(12415);
//        address.setPhoneNumber(12345678L);
//        instance.createEntity(address);

//        Address address = AddressDAO.getInstance().getEntityById(16L);
//        address.setPostalCode(12);
//        AddressDAO.getInstance().updateEntity(address);

//        AddressDAO.getInstance().removeEntity(16);

        /**
         PersonsDAO
         **/

//        Persons persons = PersonsDAO.getInstance().getEntityById(1);
//        PersonsDAO.getInstance().updateEntity(persons);
//        PersonsDAO.getInstance();

//        for (long i =15; i<30; i++){
//            PersonsDAO.getInstance().removeEntity(i);
//        }

//        PersonsDAO personsDAO = PersonsDAO.getInstance();
//        Address address = new Address();
//        address.setId(4L);
//        Persons persons = new Persons();
//        persons.setFirstName("Larissa");
//        persons.setLastName("Langosh");
//        persons.setPassportNumber(195969);
//        persons.setEmail("email1@gmail.com");
//        persons.setAddress(address);
//        personsDAO.createEntity(persons);

//        Persons persons = PersonsDAO.getInstance().getEntityById(1);
//        Address address = AddressDAO.getInstance().getEntityById(persons.getAddress().getId());
//        address.setId(4L);
//        persons.setAddress(address);
//        PersonsDAO.getInstance().updateEntity(persons);
    }
}
