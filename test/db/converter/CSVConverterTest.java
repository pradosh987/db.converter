/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.converter;

import java.io.File;
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
public class CSVConverterTest {
    
    public CSVConverterTest() {
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
     * Test of csvToMySQL method, of class CSVConverter.
     */
    @Test
    public void testCsvToMySQL() {
        System.out.println("csvToMySQL");
        DatabaseConverter data = new DatabaseConverter();
        data.setSourceFile(new File("C:\\csv\\csv1.csv"));
        data.setDestinationParam1("localhost");
        data.setDestinationParam2("3306");
        data.setDestinationParam3("test");
        data.setDestinationParam4("root");
        data.setDestinationParam5("");
        Boolean result = CSVConverter.toMySQL(data);
        if (result) {
            System.out.println("testCsvToMySQL success");
        } else {
            System.out.println("testCsvToMySQL failed");
            fail();
        }
    }
    
}
