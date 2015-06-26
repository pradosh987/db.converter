/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

    public Object excelToMySQL(DatabaseConverter data) throws Exception {
        try {
            //retrice params
            File inputFile = data.getSourceFile();

            String inputFileLocation = "E:\\ArkAngel\\csv\\file.csv";

            Connection con = Database.getInstance().getExcelConnection(inputFileLocation);

            DatabaseMetaData inputFileMetaData = con.getMetaData();

            ResultSet inputTables = inputFileMetaData.getTables(null, null, null, null);

            List<String> tables = new ArrayList<>();

            while (inputTables.next()) {
                tables.add(inputTables.getString(3));
            }

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Object mysqlToExcel(DatabaseConverter data) throws Exception {
        throw new Exception("Method not implemented");
    }

    public Boolean mysqlToOracle(DatabaseConverter data) throws Exception {
        try {

            List<String> tableNames = new ArrayList<>();
//        Connection con = Database.getInstance().getMySQLConnection("localhost", 3306, "recon", "root", "");
//        DatabaseMetaData metaData=con.getMetaData();
//        ResultSet tableData = metaData.getCatalogs();
//        while(tableData.next())
//            tableNames.add(tableData.getString(1));

            Connection con = Database.getInstance().getMySQLConnection("localhost", 3306, "recon", "root", "");
            Connection oracleConnection = Database.getInstance().getMySQLConnection("localhost", 8081, "recon", "root", "");

            ResultSet tableData = con.getMetaData().getTables(null, null, null, null);
            while (tableData.next()) {
                tableNames.add(tableData.getString("table_name"));
            }

            for (String tableName : tableNames) {
                //get data from mysql
                Statement stat = con.createStatement();
                ResultSet content = stat.executeQuery("select * from " + tableName);

                ResultSetMetaData rsmd = content.getMetaData();
                StringBuilder query = new StringBuilder();
                query.append("create table ").append(tableName).append(" (");
                final Integer columnCount = rsmd.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    query.append(rsmd.getColumnName(i)).append(" varchar(255), ");;
                }
                query.deleteCharAt(query.length() - 2);
                query.append(" )");

                //create oracle table
                Statement stat2 = oracleConnection.createStatement();
                stat2.execute(query.toString());
                query = new StringBuilder();
                //save data to oracle
                while (content.next()) {

                    query.append("insert into ").append(tableName)
                            .append(" values ").append("( ");

                    for (int j = 1; j <= columnCount; j++) {
                        query.append("'").append(content.getString(j)).append("' ,");

                    }
                    query.deleteCharAt(query.length() - 1);
                    query.append(" )");
                }

                Statement stat3 = oracleConnection.createStatement();
                stat3.executeUpdate(query.toString());
            }

        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
        return true;
    }

    public Boolean csvToMySQL(DatabaseConverter data) {
        try {
            File file = data.getSourceFile();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String content = br.readLine();
            int lineCount = 0;

            while (content != null) {
                int wordCount = 0;
                String query = "";
                StringTokenizer st = new StringTokenizer(content, ",");
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    if (lineCount == 0) {
                        if (wordCount == 0) {
                            query += token + " varchar(20)";
                        } else {
                            query += ", " + token + " varchar(20)";
                        }
                        wordCount++;
                    } else {
                        if (wordCount == 0) {
                            query += "'" + token + "'";
                        } else {
                            query += ", '" + token + "'";
                        }
                        wordCount++;
                    }

                }
                 int pos=file.getName().indexOf(".");
                    String tableName=file.getName().substring(0, pos);

                if (lineCount == 0) {
                    Connection con = Database.getInstance().getMySQLConnection("localhost",3306,"recon","root","");
                    
                    Statement stat = con.createStatement();
                   
                    String t = ("CREATE TABLE "+ tableName+ "( "  + query + ")");
                    stat.execute("CREATE TABLE "+ tableName+ "( "  + query + ")");
                    
                } else {
                    Connection con = Database.getInstance().getMySQLConnection("localhost",3306,"recon","root","");
                    
                    Statement stat = con.createStatement();
                    String sttt =("INSERT INTO " + tableName+ "VALUES (" +  query + ")");
                    stat.execute("INSERT INTO " + tableName+ "VALUES (" +  query + ")");
                }
                lineCount++;
                content = br.readLine();
            }

        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
        return true;
    }

    public Object oracleToMySQL(DatabaseConverter data) throws Exception {
        throw new Exception("Method not implemented");
    }
}
