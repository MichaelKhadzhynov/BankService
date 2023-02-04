package com.solvd.bankService.utils;

import com.solvd.bankService.dao.*;
import com.solvd.bankService.models.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.lf5.util.Resource;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.util.List;

public class MyBatisTest {
    private static final Logger LOGGER = Logger.getLogger(MyBatisTest.class);

    public static void myBatisTest() {

        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            IPersonsDAO personMyBatis = session.getMapper(IPersonsDAO.class);
//            Persons persons = personMyBatis.getEntityById(1L);
            List<Persons> personsList = personMyBatis.getPersonsList();
            personsList.forEach(LOGGER::info);
//
//            IAddressDAO addressDAO = session.getMapper(IAddressDAO.class);
//            List<Address> addressList = addressDAO.getAddressList();
//            addressList.forEach(LOGGER::info);
//
//            IAccountDetailsDAO accountDetailsDAO = session.getMapper(IAccountDetailsDAO.class);
//            AccountDetails entityById = accountDetailsDAO.getEntityById(1);
//            LOGGER.info(entityById);
//
//            IEmployeesDAO employeesDAO = session.getMapper(IEmployeesDAO.class);
//            employeesDAO.getEmployeesList().forEach(LOGGER::info);
//
//            ICashTransactionDepartmentDAO mapper = session.getMapper(ICashTransactionDepartmentDAO.class);
//            CashTransactionDepartment entityById = mapper.getEntityById(1);
//            LOGGER.info(entityById);
//
//            IClientsDAO mapper = session.getMapper(IClientsDAO.class);
//            mapper.getClientsList().forEach(LOGGER::info);
//
//            ICreditCardDAO mapper = session.getMapper(ICreditCardDAO.class);
//            mapper.getCreditCardList().forEach(LOGGER::info);
//
//            IDepositDepartmentDAO mapper = session.getMapper(IDepositDepartmentDAO.class);
//            DepositDepartment entityById = mapper.getEntityById(2);
//            LOGGER.info(entityById);
//
//            IAddressDAO addressDAO = session.getMapper(IAddressDAO.class);
//            Address address = new Address("Ukraine","Kyiv","street 1",13415,1245632L);
//            addressDAO.createEntityMyBatis(address);
//            session.commit();
//
//            IAddressDAO addressDAO = session.getMapper(IAddressDAO.class);
//            Address address = addressDAO.getEntityById(32);
//            address.setCity("Lviv");
//            addressDAO.updateEntity(address);
//            session.commit();
//
//            addressDAO.removeEntity(33);
//            session.commit();

//            try {
//                ICreditCardDAO creditCardDAO = session.getMapper(ICreditCardDAO.class);
//                IClientsDAO clientsDAO = session.getMapper(IClientsDAO.class);
//                IBankAccountDAO bankAccountDAO = session.getMapper(IBankAccountDAO.class);
//
//                CreditCard creditCard = new CreditCard();
//                creditCard.setCardNumber(12345679L);
//                creditCard.setCvv(123);
//                creditCard.setExpiredDate(Date.valueOf("2026-08-12"));
//                creditCard.setClientsId(clientsDAO.getEntityById(1));
//                creditCard.setBankAccountId(bankAccountDAO.getEntityById(2));
//                creditCardDAO.createEntityMyBatis(creditCard);
//                session.commit();
//
//            } catch (SqlSessionException e) {
//                session.rollback();
//                LOGGER.error(e);
//            }

//
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }
}
