package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.ICashTransactionDepartmentDAO;
import com.solvd.bankService.models.CashTransactionDepartment;
import com.solvd.bankService.utils.ConnectionPool;

import java.sql.*;

public class CashTransactionDepartmentDAO extends MySqlDAO implements ICashTransactionDepartmentDAO {

    private static final CashTransactionDepartmentDAO INSTANCE = new CashTransactionDepartmentDAO();
    //language=MYSQL-SQL
    private static final String SQL_SELECT = """
            SELECT * 
            FROM cash_transactions_dep
            WHERE id =?
            """;
    //language=MYSQL-SQL
    private static final String SQL_UPDATE = """
            UPDATE cash_transactions_dep 
            SET cash_in = ?,
                cash_out = ?,
                employee_id = ?         
            WHERE id = ?      
            """;
    //language=MYSQL-SQL
    private static final String SQL_DELETE = """
            DELETE FROM cash_transactions_dep
            WHERE id =? 
            """;
    //language=MYSQL-SQL
    private static final String SQL_INSERT = """
            INSERT INTO cash_transactions_dep (cash_in, cash_out, employee_id)
            VALUES ( ?, ?, ?)
            """;

    @Override
    public CashTransactionDepartment getEntityById(long id) {
        CashTransactionDepartment cashTransactionDepartment = new CashTransactionDepartment();
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT)) {

                ps.setLong(1, id);

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    cashTransactionDepartment.setId(resultSet.getLong("id"));
                    cashTransactionDepartment.setCashIn(resultSet.getInt("cash_in"));
                    cashTransactionDepartment.setCashOut(resultSet.getInt("cash_out"));

                    cashTransactionDepartment.setEmployeeId(EmployeesDao.getInstance()
                            .getEntityById(resultSet.getLong("employee_id")));
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

        return cashTransactionDepartment;
    }

    @Override
    public void updateEntity(CashTransactionDepartment cashTransactionDepartment) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {

                ps.setInt(1, cashTransactionDepartment.getCashIn());
                ps.setInt(2, cashTransactionDepartment.getCashOut());
                ps.setLong(3, cashTransactionDepartment.getEmployeeId().getId());
                ps.setLong(4, cashTransactionDepartment.getId());

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
    public CashTransactionDepartment createEntity(CashTransactionDepartment cashTransactionDepartment) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

                ps.setInt(1, cashTransactionDepartment.getCashIn());
                ps.setInt(2, cashTransactionDepartment.getCashOut());
                ps.setLong(3, cashTransactionDepartment.getEmployeeId().getId());


                ps.executeUpdate();

                ResultSet key = ps.getGeneratedKeys();
                if (key.next()) {
                    cashTransactionDepartment.setId(key.getLong(1));
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
        return cashTransactionDepartment;
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
    public void createEntityMyBatis(CashTransactionDepartment entity) {

    }

    public static CashTransactionDepartmentDAO getInstance(){
        return INSTANCE;
    }
}
