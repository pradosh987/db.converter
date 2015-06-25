/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.converter;

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
    @Test
    public void testExcelToMySQL() throws Exception {
        System.out.println("excelToMySQL");
        DatabaseConverter data = new DatabaseConverter();
        data.setSource("CSV");
        data.setDestination("MySQL");
       
        Object expResult = true;
        Object result = Converter.getInstance().excelToMySQL(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
 
}
