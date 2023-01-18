package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.IBaseDAO;
import com.solvd.bankService.models.Address;
import com.solvd.bankService.utils.ConnectionPool;

import java.sql.*;

public class AddressDAO extends MySqlDAO implements IBaseDAO<Address> {

    private static final AddressDAO INSTANCE = new AddressDAO();

    //language=MYSQL-SQL
    private static final String SQL_SELECT = """
            SELECT * 
            FROM address 
            WHERE id =?
            """;
    //language=MYSQL-SQL
    private static final String SQL_UPDATE = """
            UPDATE address 
            SET country = ?,
                city = ?,
                home_address = ?,
                postal_code = ?,
                phone = ?
            WHERE id = ?      
            """;
    //language=MYSQL-SQL
    private static final String SQL_DELETE = """
            DELETE FROM address
            WHERE id =? 
            """;
    //language=MYSQL-SQL
    private static final String SQL_INSERT = """
            INSERT INTO address (country, city, home_address, postal_code, phone)
            VALUES ( ?, ?, ?, ?, ?)
            """;


    // Overloaded method with connection parameter for excluding overfilling connection pool
    public Address getEntityById(long id, Connection connection) {
        Address address = new Address();
        Connection conn = connection;

        try {

            try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT)) {

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
    public void updateEntity(Address address) {

        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {

                ps.setString(1, address.getCountry());
                ps.setString(2, address.getCity());
                ps.setString(3, address.getHomeAddress());
                ps.setInt(4, address.getPostalCode());
                ps.setLong(5, address.getPhoneNumber());
                ps.setLong(6, address.getId());
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
    public Address createEntity(Address address) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, address.getCountry());
                ps.setString(2, address.getCity());
                ps.setString(3, address.getHomeAddress());
                ps.setInt(4, address.getPostalCode());
                ps.setLong(5, address.getPhoneNumber());


                ps.executeUpdate();

                ResultSet key = ps.getGeneratedKeys();
                if (key.next()) {
                    address.setId(key.getLong(1));
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

    public static AddressDAO getInstance() {
        return INSTANCE;
    }
}
