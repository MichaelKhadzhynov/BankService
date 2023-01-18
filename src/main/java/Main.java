import com.solvd.bankService.utils.DAOClassesTest;
import com.solvd.bankService.utils.SaxParser;
import org.apache.log4j.Logger;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

//        DAOClassesTest.DAOTesting();
        SaxParser.saxParser();
    }
}
