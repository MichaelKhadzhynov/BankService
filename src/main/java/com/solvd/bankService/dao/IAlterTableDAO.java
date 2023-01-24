package com.solvd.bankService.dao;

public interface IAlterTableDAO {

    public void addColumn(String table_name, String column_name, String data_type);

    public void renameColumn(String table_name, String old_column_name, String new_column_name);

    public void modifyColumn(String table_name, String column_name, String data_type);

    public void dropColumn(String table_name, String column_name);
}
