package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.IClientsDAO;
import com.solvd.bankService.dao.ICreditCardDAO;
import com.solvd.bankService.models.Clients;
import com.solvd.bankService.models.CreditCard;
import com.solvd.bankService.utils.ConnectionPool;

import java.sql.*;

public class CreditCardDAO extends MySqlDAO implements ICreditCardDAO {

    private static final CreditCardDAO INSTANCE = new CreditCardDAO();

    //language=MYSQL-SQL
    private static final String SQL_SELECT = """
            SELECT * 
            FROM credit_card
            WHERE id =?
            """;
    //language=MYSQL-SQL
    private static final String SQL_UPDATE = """
            UPDATE credit_card
            SET card_number = ?,
                expired_date = ?,
                cvv = ?,
                clients_id = ?,
                bank_account_id = ?                           
            WHERE id = ?      
            """;
    //language=MYSQL-SQL
    private static final String SQL_DELETE = """
            DELETE FROM credit_card
            WHERE id =? 
            """;
    //language=MYSQL-SQL
    private static final String SQL_INSERT = """
            INSERT INTO credit_card (card_number, expired_date, cvv, clients_id, bank_account_id)
            VALUES ( ?, ?, ?, ?, ?)
            """;

    @Override
    public CreditCard getEntityById(long id) {
        CreditCard creditCard = new CreditCard();
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT)) {

                ps.setLong(1, id);

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    creditCard.setId(resultSet.getLong("id"));
                    creditCard.setCardNumber(resultSet.getLong("card_number"));
                    creditCard.setExpiredDate(resultSet.getDate("expired_date"));
                    creditCard.setCvv(resultSet.getInt("cvv"));
                    creditCard.setClientsId(ClientsDAO.getInstance()
                            .getEntityById(resultSet.getLong("clients_id")));
                    creditCard.setBankAccountId(BankAccountDAO.getInstance()
                            .getEntityById(resultSet.getLong("bank_account_id")));
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
        return creditCard;
    }

    @Override
    public void updateEntity(CreditCard creditCard) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {

                ps.setLong(1, creditCard.getCardNumber());
                ps.setDate(2, creditCard.getExpiredDate());
                ps.setInt(3, creditCard.getCvv());
                ps.setLong(4,creditCard.getClientsId().getId());
                ps.setLong(5, creditCard.getBankAccountId().getId());
                ps.setLong(6, creditCard.getId());

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
    public CreditCard createEntity(CreditCard creditCard) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

                ps.setLong(1, creditCard.getCardNumber());
                ps.setDate(2, creditCard.getExpiredDate());
                ps.setInt(3, creditCard.getCvv());
                ps.setLong(4,creditCard.getClientsId().getId());
                ps.setLong(5, creditCard.getBankAccountId().getId());


                ps.executeUpdate();

                ResultSet key = ps.getGeneratedKeys();
                if (key.next()) {
                    creditCard.setId(key.getLong(1));
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
        return creditCard;
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

    public static CreditCardDAO getInstance(){
        return INSTANCE;
    }
}
