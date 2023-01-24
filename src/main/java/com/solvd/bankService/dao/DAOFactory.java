package com.solvd.bankService.dao;

import com.solvd.bankService.dao.mySQL.daoFactory.DAOFactoryMySQL;
import com.solvd.bankService.dao.mySQL.daoFactory.IDAOFactory;
import org.apache.log4j.Logger;

public class DAOFactory {



    public static IDAOFactory getFactory(String database) {
        return switch (database) {
            case "mysql" -> new DAOFactoryMySQL();
            default -> throw new IllegalStateException("invalid database");
        };
    }
}
