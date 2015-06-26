/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.converter.databases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
public class MySQLTest {

    Database instance = new MySQL("localhost", 3306, "test", "root", "");

    public MySQLTest() {
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
     * Test of getConnection method, of class MySQL.
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection test");
        boolean res = true;
        try {
            Connection result = instance.getConnection();
        } catch (Exception ex) {
            res = false;
        }
        if (res) {
            System.out.println("get connection success");
        } else {
            System.out.println("Get connection failed");
            fail();
        }
    }

    /**
     * Test of createTable method, of class MySQL.
     */
    @Test
    public void testCreateTable_String() throws Exception {
        System.out.println("createTable");
        String query = "create table demo(id varchar(10), name varchar(20))";
        boolean result = instance.createTable(query);
        if (result) {
            System.out.println("testCreateTable_String success");
        } else {
            System.out.println("testCreateTable_String failed");
            fail();
        }
    }

    /**
     * Test of createTable method, of class MySQL.
     */
    @Test
    public void testCreateTable_String_List() throws Exception {
        System.out.println("testCreateTable_String_List");
        String tableName = "info";
        List<String> columns = new ArrayList<>();
        columns.add("name");
        columns.add("lastname");
        boolean result = instance.createTable(tableName, columns);
        if (result) {
            System.out.println("testCreateTable_String_List success");
        } else {
            System.out.println("testCreateTable_String_List failed");
            fail();
        }
    }

    /**
     * Test of insert method, of class MySQL.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        String query = "insert into info values('pro','gaonkar')";

        boolean result = instance.insert(query);
        if (result) {
            System.out.println("testInsert success");
        } else {
            System.out.println("testInsert failed");
            fail();
        }
    }

    /**
     * Test of getTableData method, of class MySQL.
     */
    @Test
    public void testGetTableData() throws Exception {
        System.out.println("getTableData");
        String tableName = "info";
        
        ResultSet result = instance.getTableData(tableName);
        if (result!=null &&  result.next()) {
            System.out.println("testGetTableData success");
        } else {
            System.out.println("testGetTableData failed");
            fail();
        }
    }

    /**
     * Test of getTableNames method, of class MySQL.
     */
    @Test
    public void testGetTableNames() throws Exception {
        System.out.println("getTableNames");
        List<String> result = instance.getTableNames();
        if (result.size()<=0) {
            System.out.println("testGetTableNames failed");
            fail();
        } else {
            System.out.println("testGetTableNames success");
            for(String s:result)
                System.out.println(s);
        }
    }

    /**
     * Test of getColumnNames method, of class MySQL.
     */
    @Test
    public void testGetColumnNames() throws Exception {
        System.out.println("getColumnNames");
        String table = "info";
        List<String> result = instance.getColumnNames(table);
        if (result.size()>0) {
            System.out.println("testGetColumnNames success");
            for(String s:result)
                System.out.println(s);
        } else {
            System.out.println("testGetColumnNames failed");
            fail();
        }
    }

}
