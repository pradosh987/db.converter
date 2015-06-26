/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.converter;

import db.converter.databases.MySQL;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.StringTokenizer;

/**
 *
 * @author AION
 */
public class CSVConverter {
    
    

    public static Boolean toMySQL(DatabaseConverter data) {
        try {
            //get source
            File file = data.getSourceFile();

            //set destination
            MySQL database = new MySQL(data.getDestinationParam1(), Integer.valueOf(data.getDestinationParam2()), data.getDestinationParam3(), data.getDestinationParam4(), data.getDestinationParam5());
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            String content = br.readLine();
            int lineCount = 0;
            StringBuilder columnNames = new StringBuilder("(");

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
                        columnNames.append(token + ",");
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
                int pos = file.getName().indexOf(".");
                String tableName = file.getName().substring(0, pos);

                if (lineCount == 0) {
                    columnNames.deleteCharAt(columnNames.length() - 1);
                    columnNames.append(")");
                    database.createTable("CREATE TABLE " + tableName + "( " + query + ")");

                } else {
                    String sttt = ("INSERT INTO " + tableName + " " + columnNames.toString() + " VALUES (" + query + ")");
                    database.insert(sttt);
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

}
