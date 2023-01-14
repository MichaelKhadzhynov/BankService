package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.IPersonsDAO;
import com.solvd.bankService.models.Persons;
import com.solvd.bankService.utils.ConnectionPool;

import java.sql.*;

public class PersonsDAO extends MySqlDAO implements IPersonsDAO {

    private static final PersonsDAO INSTANCE = new PersonsDAO();

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
    //language=MYSQL-SQL
    private static final String SQL_DELETE = """
            DELETE FROM persons
            WHERE id =? 
            """;
    //language=MYSQL-SQL
    private static final String SQL_INSERT = """
            INSERT INTO persons (first_name, last_name, passport_number, email, address_id)
            VALUES ( ?, ?, ?, ?, ?)
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
    public void updateEntity(Persons person) {

        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {

                ps.setString(1, person.getFirstName());
                ps.setString(2, person.getLastName());
                ps.setInt(3, person.getPassportNumber());
                ps.setString(4, person.getEmail());
                ps.setLong(5, person.getAddress().getId());
                ps.setLong(6, person.getId());
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
    public Persons createEntity(Persons person) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, person.getFirstName());
                ps.setString(2, person.getLastName());
                ps.setInt(3, person.getPassportNumber());
                ps.setString(4, person.getEmail());
                ps.setLong(5, person.getAddress().getId());

                ps.executeUpdate();

                ResultSet key = ps.getGeneratedKeys();
                if(key.next()){
                    person.setId(key.getLong(1));
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

        return person;
    }

    @Override
    public void removeEntity(long id) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_DELETE)) {
                ps.setLong(1, id);
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


    public static PersonsDAO getInstance() {
        return INSTANCE;
    }
}
