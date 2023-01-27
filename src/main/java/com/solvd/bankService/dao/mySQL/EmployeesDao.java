package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.IEmployeesDAO;
import com.solvd.bankService.models.Employees;
import com.solvd.bankService.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao extends MySqlDAO implements IEmployeesDAO {

    private static final EmployeesDao INSTANCE = new EmployeesDao();

    private static final String SQL_SELECT_ALL="""
                    SELECT * FROM employees;
            """;
    //language=MYSQL-SQL
    private static final String SQL_SELECT = """
            SELECT * 
            FROM employees
            WHERE id =?
            """;
    //language=MYSQL-SQL
    private static final String SQL_UPDATE = """
            UPDATE employees 
            SET bank_id = ?,
                persons_id = ?,
                position  = ?,
                department = ?,
                job_experience = ?,
                education = ?,
                salary = ?         
            WHERE id = ?      
            """;
    //language=MYSQL-SQL
    private static final String SQL_DELETE = """
            DELETE FROM employees
            WHERE id =? 
            """;
    //language=MYSQL-SQL
    private static final String SQL_INSERT = """
            INSERT INTO employees (bank_id, persons_id, position, department, job_experience, education, salary)
            VALUES ( ?, ?, ?, ?, ?, ?, ?)
            """;

    @Override
    public Employees getEntityById(long id) {
        Employees employees = new Employees();
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT)) {

                ps.setLong(1, id);

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    employees.setId(resultSet.getLong("id"));
                    employees.setBankId(BankDAO.getInstance()
                            .getEntityById(resultSet.getLong("bank_id")));
                    employees.setPersonId(PersonsDAO.getInstance()
                            .getEntityById(resultSet.getLong("persons_id")));
                    employees.setPosition(resultSet.getString("position"));
                    employees.setDepartment(resultSet.getString("department"));
                    employees.setJobExperience(resultSet.getString("job_experience"));
                    employees.setEducation(resultSet.getString("education"));
                    employees.setSalary(resultSet.getInt("salary"));

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


        return employees;
    }

    @Override
    public void updateEntity(Employees employees) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {

                ps.setLong(1, employees.getBankId().getId());
                ps.setLong(2, employees.getPersonId().getId());
                ps.setString(3, employees.getPosition());
                ps.setString(4, employees.getDepartment());
                ps.setString(5, employees.getJobExperience());
                ps.setString(6, employees.getEducation());
                ps.setInt(7, employees.getSalary());
                ps.setLong(8, employees.getId());

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
    public Employees createEntity(Employees employees) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

                ps.setLong(1, employees.getBankId().getId());
                ps.setLong(2, employees.getPersonId().getId());
                ps.setString(3, employees.getPosition());
                ps.setString(4, employees.getDepartment());
                ps.setString(5, employees.getJobExperience());
                ps.setString(6, employees.getEducation());
                ps.setInt(7, employees.getSalary());

                ps.executeUpdate();

                ResultSet key = ps.getGeneratedKeys();
                if (key.next()) {
                    employees.setId(key.getLong(1));
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
        return employees;
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
    public void createEntityMyBatis(Employees entity) {

    }

    @Override
    public List<Employees> getEmployeesList() {


        List<Employees> employeesList = new ArrayList<>();

        Connection conn = null;

        try {

            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT_ALL)) {

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {

                    employeesList.add(employeeBuilder(resultSet));

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
        return employeesList;
    }

    private Employees employeeBuilder(ResultSet resultSet)throws SQLException{
        Employees employees = new Employees();
        employees.setId(resultSet.getLong("id"));
        employees.setBankId(BankDAO.getInstance()
                .getEntityById(resultSet.getLong("bank_id")));
        employees.setPersonId(PersonsDAO.getInstance()
                .getEntityById(resultSet.getLong("persons_id")));
        employees.setPosition(resultSet.getString("position"));
        employees.setDepartment(resultSet.getString("department"));
        employees.setJobExperience(resultSet.getString("job_experience"));
        employees.setEducation(resultSet.getString("education"));
        employees.setSalary(resultSet.getInt("salary"));
        return employees;
    }

    public static EmployeesDao getInstance() {
        return INSTANCE;
    }
}
