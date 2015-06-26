/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.converter;

import java.sql.Connection;
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
public class DatabaseTest {
    
    public DatabaseTest() {
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
     * Test of getExcelConnection method, of class Database.
     */
    @Test
    public void testGetExcelConnection() throws Exception {
        System.out.println("getExcelConnection");
        String file = "E:\\ArkAngel\\csv\\file.csv";
       
        boolean expResult=true ;
        try{
        Connection result = Database.getInstance().getExcelConnection(file);
        }
        catch(Exception ex){
            expResult = false;
        }
        if(expResult){
            System.err.println("Excel Pass");
        }
        else
            fail("test fail");
    }

    /**
     * Test of getMySQLConnection method, of class Database.
     */
    @Test
    public void testGetMySQLConnection() throws Exception {
        System.out.println("getMySQLConnection test");
        Database instance = Database.getInstance();
        Boolean expResult = true;
        try{
        Connection result = instance.getMySQLConnection("localhost",3306,"recon","root","");
        }catch(Exception ex){
            expResult =false;
        }
        if(expResult){
            System.err.println("MySQL Pass");
        }
        else
            fail("test fail");
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getOracleConnection method, of class Database.
     */
    @Test
    public void testGetOracleConnection() throws Exception {
        System.out.println("getOracleConnection");
        Database instance = Database.getInstance();
        boolean expResult = true;
        try{
        Connection result = instance.getOracleConnection("localhost",8081,"XE","pro","pro");
        }catch(Exception ex){
            expResult =false;
        }
        if(expResult){
            System.err.println("Oracle Pass");
        }
        else
            fail("test fail");
    }
    
    
}
