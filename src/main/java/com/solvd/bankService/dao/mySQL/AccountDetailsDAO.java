package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.IAccountDetailsDAO;
import com.solvd.bankService.models.AccountDetails;
import com.solvd.bankService.models.Bank;
import com.solvd.bankService.utils.ConnectionPool;

import java.sql.*;

public class AccountDetailsDAO extends MySqlDAO implements IAccountDetailsDAO {

    private static final AccountDetailsDAO INSTANCE = new AccountDetailsDAO();

    //language=MYSQL-SQL
    private static final String SQL_SELECT = """
            SELECT * 
            FROM account_details 
            WHERE id =?
            """;
    //language=MYSQL-SQL
    private static final String SQL_UPDATE = """
            UPDATE account_details
            SET iban_number = ?,
                bank_id = ?
            WHERE id = ?      
            """;
    //language=MYSQL-SQL
    private static final String SQL_DELETE = """
            DELETE FROM account_details
            WHERE id =? 
            """;
    //language=MYSQL-SQL
    private static final String SQL_INSERT = """
            INSERT INTO account_details (iban_number, bank_id)
            VALUES ( ?, ?)
            """;

    @Override
    public AccountDetails getEntityById(long id) {
        AccountDetails accountDetails = new AccountDetails();
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT)) {

                ps.setLong(1, id);

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    accountDetails.setId(resultSet.getLong("id"));
                    accountDetails.setIban(resultSet.getLong("iban_number"));
                    accountDetails.setBankId(BankDAO.getInstance()
                            .getEntityById(resultSet.getLong("bank_id")));
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
        return accountDetails;
    }

    @Override
    public void updateEntity(AccountDetails accountDetails) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {

                ps.setLong(1, accountDetails.getIban());
                ps.setLong(2, accountDetails.getBankId().getId());
                ps.setLong(3, accountDetails.getId());
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
    public AccountDetails createEntity(AccountDetails accountDetails) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

                ps.setLong(1, accountDetails.getIban());
                ps.setLong(2, accountDetails.getBankId().getId());


                ps.executeUpdate();

                ResultSet key = ps.getGeneratedKeys();
                if(key.next()){
                    accountDetails.setId(key.getLong(1));
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

        return accountDetails;
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

    public static AccountDetailsDAO getInstance(){
        return INSTANCE;
    }
}
