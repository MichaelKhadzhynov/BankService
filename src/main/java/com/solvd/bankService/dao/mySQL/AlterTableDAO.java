package com.solvd.bankService.dao.mySQL;

import com.solvd.bankService.dao.IAlterTableDAO;
import com.solvd.bankService.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlterTableDAO extends MySqlDAO implements IAlterTableDAO {
    private static final AlterTableDAO INSTANCE = new AlterTableDAO();

    @Override
    public void addColumn(String table_name, String column_name, String data_type) {
        Connection conn = null;
        String SQL_ALTER_TABLE_ADD_COLUMN = " ALTER TABLE " + table_name + " ADD COLUMN " + column_name + " " + data_type;
        try {
            conn = ConnectionPool.getInstance().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(SQL_ALTER_TABLE_ADD_COLUMN)) {

                ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void renameColumn(String table_name, String old_column_name, String new_column_name) {
        Connection conn = null;
        String SQL_ALTER_TABLE_ADD_COLUMN = " ALTER TABLE " + table_name + " RENAME COLUMN " + old_column_name + " to " + new_column_name;
        try {
            conn = ConnectionPool.getInstance().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(SQL_ALTER_TABLE_ADD_COLUMN)) {

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
    public void modifyColumn(String table_name, String column_name, String data_type) {
        Connection conn = null;
        String SQL_ALTER_TABLE_ADD_COLUMN = " ALTER TABLE " + table_name + " MODIFY COLUMN " + column_name + " to " + data_type;
        try {
            conn = ConnectionPool.getInstance().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(SQL_ALTER_TABLE_ADD_COLUMN)) {

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
    public void dropColumn(String table_name, String column_name) {
        Connection conn = null;
        String SQL_ALTER_TABLE_ADD_COLUMN = " ALTER TABLE " + table_name + " DROP COLUMN " + column_name;
        try {
            conn = ConnectionPool.getInstance().getConnection();
            try (PreparedStatement ps = conn.prepareStatement(SQL_ALTER_TABLE_ADD_COLUMN)) {

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

    public static AlterTableDAO getInstance() {
        return INSTANCE;
    }
}
