/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.converter;

import db.converter.databases.MySQL;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author AION
 */
public class MySQLConverter {

    public static boolean toCSV(DatabaseConverter data) {
        try {
            MySQL database = new MySQL(data.getSourceParam1(), Integer.valueOf(data.getSourceParam2()), data.getSourceParam3(), data.getSourceParam4(), data.getSourceParam5());
            List<String> tables = database.getTableNames();
            int tableCount = tables.size();
            for (String table : tables) {
                StringBuilder writer = new StringBuilder();
                List<String> columns = database.getColumnNames(table);
                int columnCount = columns.size();
                for (int i = 0; i < columnCount; i++) {
                    writer.append(columns.get(i));
                    if (i < columnCount - 1) {
                        writer.append(",");
                    }
                }
                writer.append("\n");

                ResultSet content = database.getTableData(table);
                while (content.next()) {
                    for(int i=1;i<=columnCount;i++){
                        writer.append(content.getString(i));
                        if(i!=columnCount)
                            writer.append(",");
                        else    writer.append("\n");
                    }
                }
                content.close();
                File file = new File("C:\\csv\\output\\" + data.getSourceParam3() + "\\" + table + ".csv");
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(writer.toString().getBytes());
                fos.close();
            }
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
        return true;
    }
}
