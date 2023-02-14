package com.solvd.bankService.utils.abstractFactory.Person;

import com.solvd.bankService.dao.IClientsDAO;
import com.solvd.bankService.models.Clients;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class ClientCreate implements IPerson {

    @Override
    public void create(Object person) {

        SqlSession session = session();
        IClientsDAO clientsDAO = session.getMapper(IClientsDAO.class);

        try{
            clientsDAO.createEntityMyBatis((Clients) person);
            session.commit();

        }catch(SqlSessionException e){
            session.rollback();
            e.printStackTrace();
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
