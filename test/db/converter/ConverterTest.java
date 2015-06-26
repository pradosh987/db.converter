/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.converter;

import java.io.File;
import java.sql.Connection;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AION
 */
public class ConverterTest {
    
    public ConverterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

 

    /**
     * Test of excelToMySQL method, of class Converter.
     */
//    @Test
//    public void testExcelToMySQL() throws Exception {
//        System.out.println("excelToMySQL");
//        DatabaseConverter data = new DatabaseConverter();
//        data.setSource("CSV");
//        data.setDestination("MySQL");
//       
//        Object expResult = true;
//        Object result = Converter.getInstance().excelToMySQL(data);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
//    @Test
//    public void testmysqlToOracle()throws Exception {
//        System.out.println("Starting mysqlToOracle ");
//        DatabaseConverter data = new DatabaseConverter();
//        Boolean expresult = true;
//        
//        Boolean result =  Converter.getInstance().mysqlToOracle(data);
//        if(result){
//            System.err.println("mysqlToOracle Pass");
//        }
//        else
//            fail("mysqlToOracle fail");
//    }
    
    @Test
    public void testGetMySQLConnection() throws Exception {
        System.out.println("testGetMySQLConnection");
        DatabaseConverter data = new DatabaseConverter();
        File f = new File("D:\\ArkAngel\\csv\\csv1.csv");
        data.setSourceFile(f);
        boolean expResult = true;
        try{
            Boolean result =  Converter.getInstance().csvToMySQL(data);
        }catch(Exception ex){
            expResult =false;
        }
        if(expResult){
            System.err.println("CSV to mysql Pass");
        }
        else
            fail("CSV to mysql  test fail");
    }
}
