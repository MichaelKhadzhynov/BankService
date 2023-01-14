import com.solvd.bankService.dao.mySQL.AddressDAO;
import com.solvd.bankService.dao.mySQL.PersonsDAO;
import com.solvd.bankService.models.Address;
import com.solvd.bankService.models.Persons;
import org.apache.log4j.Logger;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {



            Persons persons = PersonsDAO.getInstance().getEntityById(1);

            PersonsDAO.getInstance().updateEntity(persons);

            LOGGER.info(persons);

//        Persons persons = PersonsDAO.getInstance().getEntityById(1);
//        Address address = AddressDAO.getInstance().getEntityById(persons.getAddress().getId());
//
//        address.setId(4L);
//        persons.setAddress(address);
//
//        PersonsDAO.getInstance().updateEntity(persons);
//
//        LOGGER.info(persons);


    }
}
