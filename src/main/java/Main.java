import com.solvd.bankService.models.Clients;
import com.solvd.bankService.models.Persons;
import com.solvd.bankService.utils.ClientList;
import com.solvd.bankService.utils.CreditCardsList;
import com.solvd.bankService.utils.EmployeesList;
import com.solvd.bankService.utils.MyHandler;
import com.solvd.bankService.utils.abstractFactory.Factory.PersonFactory;
import com.solvd.bankService.utils.abstractFactory.FactoryConfig;
import com.solvd.bankService.utils.abstractFactory.PersonsType;
import com.solvd.bankService.utils.observer.*;
import com.solvd.bankService.utils.parsersFactory.ParserFactory;
import org.apache.log4j.Logger;


public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
//
//        String xmlFile = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/files/Employees.xml";
//        String xmlFileWrite = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/files/EmployeesNew.xml";
//        String jsonFile = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/files/ClientList.json";
//        String jsonFileWrite = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/files/CreditCardsListWrite.json";
//
//        ParserFactory.getInstance().getDomParser(xmlFile, "employee").readFile();
//        ParserFactory.getInstance().getSAXParser(xmlFile, new MyHandler<>()).readFile();
//        ParserFactory.getInstance().getSTAXParserRead(xmlFile, "employee").readFile();
//        ParserFactory.getInstance().getSTAXParserWrite(xmlFileWrite).writeFile();
//
//        EmployeesList employeesList = new EmployeesList();
//        employeesList = (EmployeesList) ParserFactory.getInstance()
//                .getJaxbParser(xmlFile, employeesList)
//                .readFile();
//        employeesList.getEmployees().forEach(LOGGER::info);
//
//        ParserFactory.getInstance().getJaxbParser(xmlFileWrite, employeesList).writeFile();
//
//        ClientList clientList = new ClientList();
//        clientList = (ClientList) ParserFactory.getInstance().getJacksonParser(jsonFile,clientList).readFile();
//        clientList.getClientList().forEach(LOGGER::info);
//
//        CreditCardsList creditCardsList = new CreditCardsList();
//        ParserFactory.getInstance().getJacksonParser(jsonFileWrite, creditCardsList).writeFile();


//        Clients client = new Clients();
//        Persons p = new Persons();
//        p.setId(5L);
//        client.setPersonId(p);
//        client.setClientType("Physical person");
//
//        PersonFactory personFactory = FactoryConfig.configureFactory(PersonsType.CLIENT);
//        personFactory.create(client);


//        BankNews bankNews = new BankNews();
//        IObserver clientJack = new Client("Jack");
//        IObserver employeeJohn = new Employee("John");
//        IObserver employeeAlise = new Employee("Alise");
//
//        bankNews.addObserver(clientJack);
//        bankNews.addObserver(employeeJohn);
//        bankNews.addObserver(employeeAlise);
//
//        bankNews.addNews(PersonType.CLIENT, "New deposits percents 5%, 6%, 10%");
//        bankNews.addNews(PersonType.EMPLOYEE, "Good news we rise vacation period");








//        ClientCreation.clientCreate();
//        AlterTableDAO.getInstance().addColumn("bank", "bank_logo", "BLOB");
//        AlterTableDAO.getInstance().dropColumn("bank","bank_logo");
//        BankDAO.getInstance().addBankLogo(2,"/Users/michael/div/IntelejIDEA Project/BankService/src/main/resources/bankLogo.png");
//        MyBatisTest.myBatisTest();


    }


}
