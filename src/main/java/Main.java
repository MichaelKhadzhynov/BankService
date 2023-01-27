import com.solvd.bankService.dao.mySQL.AlterTableDAO;
import com.solvd.bankService.utils.MyBatisTest;
import org.apache.ibatis.javassist.Loader;
import org.apache.log4j.Logger;



public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

//        DAOClassesTest.DAOTesting();

//        SaxParser.saxParser();

//        StaxParser.staxParsing();

//        StaxWriter.staxOutWriter();
//
//        DOMParser.domParser();

//        ClientCreation.clientCreate();

//        for (int i = 20; i <40 ; i++) {
//            AddressDAO.getInstance().removeEntity(i);
//        }

//        JaxbEx.jaxbStartRead();
//        JaxbEx.jaxbStartWrite();
//        EmployeesDao.getInstance().getEmployeesList().forEach(System.out::println);


//        AlterTableDAO.getInstance().addColumn("bank", "bank_logo", "BLOB");
//        AlterTableDAO.getInstance().dropColumn("bank","bank_logo");

//        BankDAO.getInstance().addBankLogo(2,"/Users/michael/div/IntelejIDEA Project/BankService/src/main/resources/bankLogo.png");

//        Jackson.jacksonRead();
//        Jackson.jacksonWrite();
//        Jackson.jacksonWriteCreditCards();

        MyBatisTest.myBatisTest();
        


    }
}
