/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.converter.databases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author AION
 */
public interface Database {
    /**
     * Creates connection to database
     * @return  Connection
     * @throws Exception 
     */
    public Connection getConnection() throws Exception;
    
    /**
     * Creates a table in database
     * @param query Complete create table query
     * @return  True if table is created successfully and false otherwise
     * @throws Exception 
     */
    public boolean createTable(String query) ;
    
    /**
     * Creates a table in database
     * @param tableName Name of the new table
     * @param columns   List of column names
     * @return  True if success, false otherwise
     * @throws Exception 
     */
    public boolean createTable(String tableName, List<String> columns) ;
    
    /**
     * Inserts data into database
     * @param query Compelete insert query;
     * @return  True if success
     * @throws Exception 
     */
    public boolean insert(String query) throws Exception;
    
    /**
     * Get all data from table
     * @param tableName Table name
     * @return  Resultset object
     * @throws Exception 
     */
    public ResultSet getTableData(String tableName) throws Exception;
    
    /**
     * Returns names of table from database
     * @return  List of table names
     * @throws Exception 
     */
    public List<String> getTableNames() throws Exception;
    
    /**
     * Returns column names from database
     * @param table name of the table
     * @return  List of column names
     * @throws Exception 
     */
    public List<String> getColumnNames(String table) throws Exception;
}
