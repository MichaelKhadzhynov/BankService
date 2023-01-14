package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.IPersonsDAO;
import com.solvd.bankService.models.Persons;
import com.solvd.bankService.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonsDAO extends MySqlDAO implements IPersonsDAO {

    private static final PersonsDAO INSTANCE = new PersonsDAO();
    private static final Logger LOGGER = Logger.getLogger(PersonsDAO.class);

    //language=MYSQL-SQL
    private static final String SQL_SELECT = """
            SELECT * 
            FROM persons 
            WHERE id =?
            """;
    //language=MYSQL-SQL
    private static final String SQL_UPDATE = """
            UPDATE persons 
            SET first_name = ?,
                last_name = ?,
                passport_number = ?,
                email = ?,
                address_id = ?
            WHERE id =?      
            """;

    @Override
    public Persons getEntityById(long id) {

        Persons persons = new Persons();
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT)) {

                ps.setLong(1, id);

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    persons.setId(resultSet.getLong("id"));
                    persons.setFirstName(resultSet.getString("first_name"));
                    persons.setLastName(resultSet.getString("last_name"));
                    persons.setPassportNumber(resultSet.getInt("passport_number"));
                    persons.setEmail(resultSet.getString("email"));

                    persons.setAddress(AddressDAO.getInstance()
                            .getEntityById(resultSet.getLong("address_id"),
                                    resultSet.getStatement().getConnection()));
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

        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {

                ps.setString(1, entity.getFirstName());
                ps.setString(2, entity.getLastName());
                ps.setInt(3, entity.getPassportNumber());
                ps.setString(4, entity.getEmail());
                ps.setLong(5, entity.getAddress().getId());
                ps.setLong(6, entity.getId());
                ps.executeUpdate();
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
    }

    @Override
    public Persons createEntity(Persons entity) {
        return null;
    }

    @Override
    public void removeEntity(long id) {

    }

    public static PersonsDAO getInstance() {
        return INSTANCE;
    }
}
