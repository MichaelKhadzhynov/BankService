package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.IBaseDAO;
import com.solvd.bankService.models.Address;
import com.solvd.bankService.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAO extends MySqlDAO implements IBaseDAO<Address> {

    private static final AddressDAO INSTANCE = new AddressDAO();
    private static final Logger LOGGER = Logger.getLogger(PersonsDAO.class);



    public Address getEntityById(long id, Connection connection){
        Address address = new Address();
        Connection conn = connection;

        try {
            //language=MYSQL-SQL
            String sql = """
                    SELECT * FROM address WHERE id =?
                    """;
            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setLong(1, id);

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    address.setId(resultSet.getLong("id"));
                    address.setCountry(resultSet.getString("country"));
                    address.setCity(resultSet.getString("city"));
                    address.setHomeAddress(resultSet.getString("home_address"));
                    address.setPostalCode(resultSet.getInt("postal_code"));
                    address.setPhoneNumber(resultSet.getLong("phone"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return address;
    }


    @Override
    public Address getEntityById(long id) {

        Address address = new Address();
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            String sql = """
                    SELECT * FROM address WHERE id =?
                    """;

            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setLong(1, id);

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    address.setId(resultSet.getLong("id"));
                    address.setCountry(resultSet.getString("country"));
                    address.setCity(resultSet.getString("city"));
                    address.setHomeAddress(resultSet.getString("home_address"));
                    address.setPostalCode(resultSet.getInt("postal_code"));
                    address.setPhoneNumber(resultSet.getLong("phone"));
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

        return address;
    }

    @Override
    public void updateEntity(Address entity) {

    }

    @Override
    public Address createEntity(Address entity) {
        return null;
    }

    @Override
    public void removeEntity(long id) {

    }

    public static AddressDAO getInstance() {
        return INSTANCE;
    }
}
