import org.apache.log4j.Logger;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {



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

//        AccountDetails entityById = AccountDetailsDAO.getInstance().getEntityById(11);
//        LOGGER.info(entityById);

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
