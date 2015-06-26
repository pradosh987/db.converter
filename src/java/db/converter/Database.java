/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.converter;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author AION
 */
public class Database {

    private static Database instance = new Database();

    private Database() {

    }

    public static Database getInstance() {
        return instance;
    }

    /**
     * Returns connection to Excel file
     * @param file  File path
     * @return  Connection
     * @throws Exception On failure
     */
    public Connection getExcelConnection(String file) throws Exception {
        try {
            Class.forName("sun.jdbc.odbc.JdbcJdbcDriver");
            return DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Excel Driver (*xl,*.xls)};DBQ=" + file + ".xls;");

        } catch (Exception ex) {
            System.err.println(ex);
            throw new Exception("Error generating Excel Connection object");
        }
    }
    
    public Connection getMySQLConnection(String server,int port, String databaseName, String username, String password) throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+databaseName+"",username,password);
        }
        catch(Exception ex){
            System.err.println(ex);
            throw new Exception("Error establishing connection");
        }
    }
    
    public Connection getOracleConnection(String server,int port, String databaseName, String username, String password) throws Exception{
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String test = "jdbc:oracle:thin:@"+server+":"+port+":"+databaseName;

	return DriverManager.getConnection("jdbc:oracle:thin:@"+server+":"+port+":"+databaseName,username,password);
        }catch (Exception ex) {
            System.err.println(ex);
            throw new Exception("Error generating Oracle Connection object");
        }
    }
}
