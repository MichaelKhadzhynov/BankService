import com.solvd.bankService.dao.mySQL.PersonsDAO;
import com.solvd.bankService.models.Persons;
import org.apache.log4j.Logger;

import javax.sql.ConnectionPoolDataSource;
import java.sql.Connection;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {


        PersonsDAO personsDAO = new PersonsDAO();
        personsDAO.getEntityById(1);

        LOGGER.info(personsDAO.getEntityById(1));

    }
}
