import org.apache.log4j.Logger;

import javax.sql.ConnectionPoolDataSource;
import java.sql.Connection;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("new project");
        LOGGER.error("new project");

    }
}
