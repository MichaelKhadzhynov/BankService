package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.IBankDAO;
import com.solvd.bankService.models.Bank;
import com.solvd.bankService.utils.ConnectionPool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

public class BankDAO extends MySqlDAO implements IBankDAO {

    private static final BankDAO INSTANCE = new BankDAO();

    //language=MYSQL-SQL
    private static final String SQL_SELECT = """
            SELECT * 
            FROM bank
            WHERE id =?
            """;
    //language=MYSQL-SQL
    private static final String SQL_UPDATE = """
            UPDATE bank 
            SET bank_number = ?,
                address_id = ?            
            WHERE id = ?      
            """;
    //language=MYSQL-SQL
    private static final String SQL_DELETE = """
            DELETE FROM bank
            WHERE id =? 
            """;
    //language=MYSQL-SQL
    private static final String SQL_INSERT = """
            INSERT INTO bank (bank_number, address_id)
            VALUES ( ?, ?)
            """;

    private static final String SQL_ADD_BLOB = """
                UPDATE bank
                SET bank_logo = ?
                WHERE id = ?""";

    public static BankDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Bank getEntityById(long id) {
        Bank bank = new Bank();
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT)) {

                ps.setLong(1, id);

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    bank.setId(resultSet.getLong("id"));
                    bank.setBankNumber(resultSet.getInt("bank_number"));

                    bank.setAddressId(AddressDAO.getInstance()
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
        return bank;
    }

    @Override
    public void updateEntity(Bank bank) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {

                ps.setInt(1, bank.getBankNumber());
                ps.setLong(2, bank.getAddressId().getId());
                ps.setLong(3, bank.getId());

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
    public Bank createEntity(Bank bank) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

                ps.setInt(1, bank.getBankNumber());
                ps.setLong(2, bank.getAddressId().getId());


                ps.executeUpdate();

                ResultSet key = ps.getGeneratedKeys();
                if (key.next()) {
                    bank.setId(key.getLong(1));
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
        return bank;
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

    @Override
    public void createEntityMyBatis(Bank entity) {

    }

    @Override
    public void addBankLogo(long id, String fileName) {

        Connection conn = null;
        try {
            conn = ConnectionPool.getInstance().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(SQL_ADD_BLOB)) {

                Blob blob = conn.createBlob();
                blob.setBytes(1, Files.readAllBytes(Path.of(fileName)));

                ps.setBlob(1, blob);
                ps.setLong(2, id);

                ps.executeUpdate();

            }
        } catch (SQLException | IOException e) {
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
}
