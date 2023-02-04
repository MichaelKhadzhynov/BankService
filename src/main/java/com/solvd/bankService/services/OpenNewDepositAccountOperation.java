package com.solvd.bankService.services;

import com.solvd.bankService.dao.IClientsDAO;
import com.solvd.bankService.dao.IDepositDepartmentDAO;
import com.solvd.bankService.dao.IEmployeesDAO;
import com.solvd.bankService.models.Clients;
import com.solvd.bankService.models.DepositDepartment;
import com.solvd.bankService.models.Employees;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public abstract class OpenNewDepositAccountOperation {
    private static final Logger LOGGER = Logger.getLogger(OpenNewDepositAccountOperation.class);

    private static final Long employeeId = 4L;
    private static final Long clientId = 3L;
    private static final Integer cash = 2000;
    private static final Integer depositPercent = 10;

    public static void openDepositOperation() {

        SqlSession session = session();
        IDepositDepartmentDAO depositDepartmentDAO = session.getMapper(IDepositDepartmentDAO.class);

        DepositDepartment deposit = new DepositDepartment();
        deposit.setDepositPercent(depositPercent);
        deposit.setCash(cash);
        deposit.setClientId(clients());
        deposit.setEmployeeId(employee());

        if (clients() != null && employee() != null) {

            try {
                depositDepartmentDAO.createEntityMyBatis(deposit);
                session.commit();
                LOGGER.info("New deposit account creation failed success");

            } catch (SqlSessionException e) {
                session.rollback();
                LOGGER.error(e);
            }
            LOGGER.info(clients() + "\n" + employee());
        } else {
            LOGGER.info("New deposit account creation failed");
        }

    }

    private static Clients clients() {

        IClientsDAO clientsDAO = session().getMapper(IClientsDAO.class);

        Clients client = clientsDAO.getEntityById(clientId);

        if (client != null) {
            return client;
        } else {
            LOGGER.info("Client not found");
            return null;
        }

    }

    private static Employees employee() {

        IEmployeesDAO employeesDAO = session().getMapper(IEmployeesDAO.class);

        Employees employeesDepositDep = employeesDAO.getEntityById(employeeId);

        if (employeesDepositDep.getDepartment().equals("Deposits")) {
            return employeesDepositDep;
        } else {
            LOGGER.info("Employee not found in this department");
            return null;
        }
    }

    private static SqlSession session() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            return sqlSessionFactory.openSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
