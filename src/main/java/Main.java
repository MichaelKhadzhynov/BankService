import com.solvd.bankService.dao.mySQL.*;
import com.solvd.bankService.models.*;
import org.apache.log4j.Logger;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {


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

//        Employees entityById = EmployeesDao.getInstance().getEntityById(1);
//        LOGGER.info(entityById.getPersonId().getFirstName());

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
