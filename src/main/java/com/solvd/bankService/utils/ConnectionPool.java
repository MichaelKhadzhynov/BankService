package com.solvd.bankService.utils;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ConnectionPool {

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static final ConnectionPool INSTANCE = new ConnectionPool();
    private static final String FILENAME = "mysql";



    private final int maxPoolSize = 5;
    private int connectionNumber = 0;

    private static final String SQL_VERIFICATION = "select_1";

    Stack<Connection> freePool = new Stack<>();
    Set<Connection> occupiedPool = new HashSet<>();

    private ConnectionPool() {
    }

    public synchronized Connection getConnection() throws SQLException {
        Connection conn = null;
        if (isFull()) {
            throw new SQLException("Connection pool is full");
        }
        conn = getConnectionFromPool() ;
        if (conn == null) {
            conn = createNewConnectionForPool();
        }

        conn = makeAvailable(conn);
//        LOGGER.info("Connection number - " + connectionNumber + " | " + " Thread ID - " + " " + Thread.currentThread().getId());

        return conn;
    }

    public synchronized void releaseConnection(Connection conn) throws SQLException {
        if (conn == null) {
            throw new NullPointerException();
        }

        if (!occupiedPool.remove(conn)) {
            throw new SQLException("Connection is returned already or it isn't for this pool");
        }

        freePool.push(conn);
    }

    private synchronized boolean isFull() {

        return ((freePool.size() == 0) && (connectionNumber >= maxPoolSize));
    }

    private Connection createNewConnectionForPool() throws SQLException {
        Connection conn = createNewConnection();
        connectionNumber++;
        occupiedPool.add(conn);
        return conn;
    }

    private Connection createNewConnection() throws SQLException {

        ResourceBundle resourceBundle = ResourceBundle.getBundle(FILENAME);

        String dbUrl = resourceBundle.getString("DBDataBaseUrl");
        String dbName = resourceBundle.getString("DBUserName");
        String dbPassword = resourceBundle.getString("DBPassword");

        return DriverManager.getConnection(dbUrl, dbName, dbPassword);
    }

    private Connection getConnectionFromPool()  {
        Connection conn = null;
        if (freePool.size() > 0) {
            conn = freePool.pop();
            occupiedPool.add(conn);
        }
        return conn;
    }

    private Connection makeAvailable(Connection conn) throws SQLException{
        if (isConnectionAvailable(conn)){
            return conn;
        }
        occupiedPool.remove(conn);
        connectionNumber--;
        conn.close();

        conn = createNewConnection();
        occupiedPool.add(conn);
        connectionNumber++;
        return conn;
    }

    private boolean isConnectionAvailable(Connection conn){
        try (Statement st = conn.createStatement()) {
            st.executeQuery(SQL_VERIFICATION);
            return  true;
        } catch (SQLException e){
            return false;
        }
    }


    public static ConnectionPool getInstance() {
        return ConnectionPool.INSTANCE;
    }
}
