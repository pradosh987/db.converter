/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.converter;

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
            String filePath=data.getSource();
            
            
            
            
            
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
