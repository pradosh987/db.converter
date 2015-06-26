/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.converter.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AION
 */
public class MySQL implements Database {

    private static final int defaultPort = 3306;
    private static final String defaultServer = "localhost";

    private final String server;
    private final Integer port;
    private final String databaseName;
    private final String username;
    private final String password;
    private final String connectionString;

    /**
     * Create MySQL database object
     *
     * @param server Database server
     * @param port Port
     * @param databaseName Database name
     * @param username Username
     * @param password Password
     */
    public MySQL(String server, Integer port, String databaseName, String username, String password) {
        this.server = server;
        this.port = port;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
        this.connectionString = "jdbc:mysql://" + server + ":" + port + "/" + databaseName;
    }

    /**
     * Create MySQL database object
     *
     * @param connectionString Connection string
     * @param username Username
     * @param password Password
     */
    public MySQL(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
        this.server = defaultServer;
        this.databaseName = "database";
        this.port = defaultPort;
    }

    @Override
    public Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + databaseName + "", username, password);
        } catch (Exception ex) {
            System.err.println(ex);
            throw ex;
        }
    }

    @Override
    public boolean createTable(String query) {
        try {
            Connection con = getConnection();
            Statement stat = con.createStatement();
            stat.execute(query);
            con.close();
            return true;
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    @Override
    public boolean createTable(String tableName, List<String> columns) {
        //prepare query here
        StringBuilder query = new StringBuilder();
        try {
            query.append("create table ").append(tableName).append(" (");
            for (String column : columns) {
                query.append(column).append(" varchar(255), ");
            }
            query.deleteCharAt(query.length() - 2);
            query.append(" )");
            return createTable(query.toString());
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean insert(String query) throws Exception {
        try {
            Connection con = getConnection();
            Statement stat = con.createStatement();
            stat.execute(query);
            con.close();
            return true;
        } catch (Exception ex) {
            System.err.println(ex);
            throw ex;
        }
    }

    @Override
    public ResultSet getTableData(String tableName) throws Exception {
        try {
            Connection con = getConnection();
            Statement stat = con.createStatement();
            return stat.executeQuery("select * from " + tableName);
        } catch (Exception ex) {
            System.err.println(ex);
            throw ex;
        }

    }

    @Override
    public List<String> getTableNames() throws Exception {
        List<String> tables = new ArrayList<>();
        try {
            Connection con = getConnection();
            ResultSet data = con.getMetaData().getTables(null, null, null, null);
            while (data.next()) {
                tables.add(data.getString("table_name"));
            }
            data.close();
            con.close();
        } catch (Exception ex) {
            System.err.println(ex);
            throw ex;
        }
        return tables;
    }

    @Override
    public List<String> getColumnNames(String table) throws Exception {
        List<String> columns = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet data = getTableData(table);
            ResultSetMetaData rsmd = data.getMetaData();
            final int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columns.add(rsmd.getColumnName(i));
            }
            con.close();
        } catch (Exception ex) {
            System.err.println(ex);
            throw ex;
        }
        return columns;
    }

}
