package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.IPersonsDAO;
import com.solvd.bankService.models.Persons;
import com.solvd.bankService.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;

public class PersonsDAO extends MySqlDAO implements IPersonsDAO {

    private final static Logger LOGGER = Logger.getLogger(PersonsDAO.class);

    private String GETPERSON = "select * from persons where id =";

    @Override
    public Persons getEntityById(long id)  {

        Persons persons = new Persons();
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(GETPERSON + id)) {

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()){
                    persons.setId(resultSet.getLong("id"));
                    persons.setFirstName(resultSet.getString("first_name"));
                    persons.setLastName(resultSet.getString("last_name"));
                    persons.setPassportNumber(resultSet.getInt("passport_number"));
                    persons.setEmail(resultSet.getString("email"));
                    persons.setAddressId(resultSet.getLong("address_id"));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    ConnectionPool.getInstance().releaseConnection(conn);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return persons;
    }

    @Override
    public void updateEntity(Persons entity) {

    }

    @Override
    public Persons createEntity(Persons entity) {
        return null;
    }

    @Override
    public void removeEntity(long id) {

    }
}
