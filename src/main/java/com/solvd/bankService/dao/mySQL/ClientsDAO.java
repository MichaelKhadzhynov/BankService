package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.IClientsDAO;
import com.solvd.bankService.models.Clients;
import com.solvd.bankService.models.Employees;
import com.solvd.bankService.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDAO extends MySqlDAO implements IClientsDAO {

    private static final ClientsDAO INSTANCE = new ClientsDAO();
    //language=MYSQL-SQL
    private static final String SQL_SELECT = """
            SELECT * 
            FROM clients
            WHERE id =?
            """;

    private static final String SQL_SELECT_ALL="""
                    SELECT * FROM clients;
            """;
    //language=MYSQL-SQL
    private static final String SQL_UPDATE = """
            UPDATE clients 
            SET persons_id = ?,
                client_type = ?            
            WHERE id = ?      
            """;
    //language=MYSQL-SQL
    private static final String SQL_DELETE = """
            DELETE FROM clients
            WHERE id =? 
            """;
    //language=MYSQL-SQL
    private static final String SQL_INSERT = """
            INSERT INTO clients (persons_id, client_type)
            VALUES ( ?, ?)
            """;
    @Override
    public Clients getEntityById(long id) {
        Clients clients = new Clients();
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT)) {

                ps.setLong(1, id);

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    clients.setId(resultSet.getLong("id"));
                    clients.setPersonId(PersonsDAO.getInstance()
                            .getEntityById(resultSet.getLong("persons_id")));
                    clients.setClientType(resultSet.getString("client_type"));
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
        return clients;
    }

    @Override
    public void updateEntity(Clients clients) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {

                ps.setLong(1, clients.getPersonId().getId());
                ps.setString(2, clients.getClientType());
                ps.setLong(3, clients.getId());

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
    public Clients createEntity(Clients clients) {
        Connection conn = null;

        try {
            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

                ps.setLong(1, clients.getPersonId().getId());
                ps.setString(2, clients.getClientType());


                ps.executeUpdate();

                ResultSet key = ps.getGeneratedKeys();
                if (key.next()) {
                    clients.setId(key.getLong(1));
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
        return clients;
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
    public List<Clients> getClientsList(){
        List<Clients> clientList = new ArrayList<>();

        Connection conn = null;

        try {

            conn = ConnectionPool.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT_ALL)) {

                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {

                    clientList.add(clientBuilder(resultSet));

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
        return clientList;
    }

    private Clients clientBuilder (ResultSet resultSet) throws SQLException {
        Clients clients = new Clients();
        clients.setId(resultSet.getLong("id"));
        clients.setPersonId(PersonsDAO.getInstance()
                .getEntityById(resultSet.getLong("persons_id")));
        clients.setClientType(resultSet.getString("client_type"));
        return clients;
    }

    public static ClientsDAO getInstance(){
        return INSTANCE;
    }
}
