/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.converter;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AION
 */
public class Converter {

    private static Converter instance = new Converter();

    private Converter() {

    }

    public static Converter getInstance() {
        return instance;
    }

    public Object excelToMySQL(DatabaseConverter data) throws Exception{
        try
        {
            //retrice params
            File inputFile=data.getSourceFile();
            
            String inputFileLocation = "E:\\ArkAngel\\csv\\file.csv";
            
            Connection con = Database.getInstance().getExcelConnection(inputFileLocation);
            
            DatabaseMetaData inputFileMetaData=con.getMetaData();
            
            ResultSet inputTables= inputFileMetaData.getTables(null, null, null, null);
            
            List<String> tables = new ArrayList<>();
            
            while(inputTables.next())
                tables.add(inputTables.getString(3));
            
            
            
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
    public Object mysqlToExcel(DatabaseConverter data) throws Exception{
        throw new Exception("Method not implemented");
    }
    
    public Object mysqlToOracle(DatabaseConverter data) throws Exception{
        throw new Exception("Method not implemented");
    }
    
    public Object oracleToMySQL(DatabaseConverter data) throws Exception{
        throw new Exception("Method not implemented");
    }
}
