package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.IBankAccountDAO;
import com.solvd.bankService.models.BankAccount;
import com.solvd.bankService.utils.ConnectionPool;

import java.sql.*;

public class BankAccountDAO extends MySqlDAO implements IBankAccountDAO {

    private static final BankAccountDAO INSTANCE = new BankAccountDAO();
    //language=MYSQL-SQL
    private static final String SQL_SELECT = """
            SELECT * 
            FROM bank_account 
            WHERE id =?
            """;
    //language=MYSQL-SQL
    private static final String SQL_UPDATE = """
            UPDATE bank_accaunt
            SET account_number = ?,
                balance = ?,
                account_type= ?,
                account_details_id = ?
            WHERE id = ?      
            """;
    //language=MYSQL-SQL
    private static final String SQL_DELETE = """
            DELETE FROM bank_account
            WHERE id =? 
            """;
    //language=MYSQL-SQL
    private static final String SQL_INSERT = """
            INSERT INTO bank_account (account_number, balance, account_type, account_details_id)
            VALUES ( ?, ?, ?, ?)
            """;

    @Override
    public BankAccount getEntityById(long id) {
        BankAccount bankAccount = new BankAccount();

        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT)) {

                ps.setLong(1, id);

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    bankAccount.setId(resultSet.getLong("id"));
                    bankAccount.setAccountNumber(resultSet.getLong("account_number"));
                    bankAccount.setBalance(resultSet.getInt("balance"));
                    bankAccount.setAccountType(resultSet.getString("account_type"));
                    bankAccount.setAccountDetailsId(AccountDetailsDAO.getInstance()
                            .getEntityById(resultSet.getLong("account_details_id")));


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

        return bankAccount;
    }

    @Override
    public void updateEntity(BankAccount bankAccount) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {

                ps.setLong(1, bankAccount.getAccountNumber());
                ps.setInt(2, bankAccount.getBalance());
                ps.setString(3, bankAccount.getAccountType());
                ps.setLong(4, bankAccount.getAccountDetailsId().getId());
                ps.setLong(5, bankAccount.getId());
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
    public BankAccount createEntity(BankAccount bankAccount) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

                ps.setLong(1, bankAccount.getAccountNumber());
                ps.setInt(2, bankAccount.getBalance());
                ps.setString(3, bankAccount.getAccountType());
                ps.setLong(4, bankAccount.getAccountDetailsId().getId());
                ps.executeUpdate();

                ResultSet key = ps.getGeneratedKeys();
                if (key.next()) {
                    bankAccount.setId(key.getLong(1));
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

        return bankAccount;
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
    public void createEntityMyBatis(BankAccount entity) {

    }

    public static BankAccountDAO getInstance() {
        return INSTANCE;
    }
}
