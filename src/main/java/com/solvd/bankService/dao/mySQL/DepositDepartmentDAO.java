package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.IDepositDepartmentDAO;
import com.solvd.bankService.models.DepositDepartment;
import com.solvd.bankService.utils.ConnectionPool;

import java.sql.*;

public class DepositDepartmentDAO extends MySqlDAO implements IDepositDepartmentDAO {

    private static final DepositDepartmentDAO INSTANCE = new DepositDepartmentDAO();
    //language=MYSQL-SQL
    private static final String SQL_SELECT = """
            SELECT * 
            FROM deposit_dep
            WHERE id =?
            """;
    //language=MYSQL-SQL
    private static final String SQL_UPDATE = """
            UPDATE deposit_dep 
            SET clients_id = ?,
                cash = ?,
                deposit_perсent = ?,
                employee_id = ?            
            WHERE id = ?      
            """;
    //language=MYSQL-SQL
    private static final String SQL_DELETE = """
            DELETE FROM deposit_dep
            WHERE id =? 
            """;
    //language=MYSQL-SQL
    private static final String SQL_INSERT = """
            INSERT INTO deposit_dep (clients_id, cash, deposit_perсent, employee_id)
            VALUES ( ?, ?, ?, ?)
            """;

    @Override
    public DepositDepartment getEntityById(long id) {
        DepositDepartment depositDepartment = new DepositDepartment();
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT)) {

                ps.setLong(1, id);

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    depositDepartment.setId(resultSet.getLong("id"));
                    depositDepartment.setClientId(ClientsDAO.getInstance()
                            .getEntityById(resultSet.getLong("clients_id")));
                    depositDepartment.setCash(resultSet.getInt("cash"));
                    depositDepartment.setDepositPercent(resultSet.getInt("deposit_perсent"));
                    depositDepartment.setEmployeeId(EmployeesDao.getInstance()
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

        return depositDepartment;
    }

    @Override
    public void updateEntity(DepositDepartment depositDepartment) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {

                ps.setLong(1, depositDepartment.getClientId().getId());
                ps.setInt(2, depositDepartment.getCash());
                ps.setInt(3, depositDepartment.getDepositPercent());
                ps.setLong(4, depositDepartment.getEmployeeId().getId());
                ps.setLong(5, depositDepartment.getId());

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
    public DepositDepartment createEntity(DepositDepartment depositDepartment) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

                ps.setLong(1, depositDepartment.getClientId().getId());
                ps.setInt(2, depositDepartment.getCash());
                ps.setInt(3, depositDepartment.getDepositPercent());
                ps.setLong(4, depositDepartment.getEmployeeId().getId());


                ps.executeUpdate();

                ResultSet key = ps.getGeneratedKeys();
                if (key.next()) {
                    depositDepartment.setId(key.getLong(1));
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

        return depositDepartment;
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

    public static DepositDepartmentDAO getInstance(){
        return INSTANCE;
    }
}
