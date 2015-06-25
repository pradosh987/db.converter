package db.converter;

import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AION
 */
public class DatabaseConverter {

    private String name;

    private String source;

    private String destination;

    private String sourceParam1;

    private String sourceParam2;

    private String sourceParam3;

    private String sourceParam4;

    private String sourceParam5;

    private File sourceFile;

    private String destinationParam1;

    private String destinationParam2;

    private String destinationParam3;

    private String destinationParam4;

    private String destinationParam5;

    public String execute() {
        //validate and select conversion logic here
        try {
            if (getSource().equals("Excel") && getDestination().equals("MySQL")) {
                Converter.getInstance().excelToMySQL(this);
            } else if (getSource().equals("MySQL") && getDestination().equals("Excel")) {
                Converter.getInstance().mysqlToExcel(this);
            } else if (getSource().equals("Oracle") && getDestination().equals("MySQL")) {
                Converter.getInstance().oracleToMySQL(this);
            } else if (getSource().equals("MySQL") && getDestination().equals("Oracle")) {
                Converter.getInstance().mysqlToExcel(this);
            }

            return "success";
        } catch (Exception ex) {
            return "failure";
        }
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getSourceParam1() {
        return sourceParam1;
    }

    public String getSourceParam2() {
        return sourceParam2;
    }

    public String getSourceParam3() {
        return sourceParam3;
    }

    public String getSourceParam4() {
        return sourceParam4;
    }

    public String getSourceParam5() {
        return sourceParam5;
    }

    public String getDestinationParam1() {
        return destinationParam1;
    }

    public String getDestinationParam2() {
        return destinationParam2;
    }

    public String getDestinationParam3() {
        return destinationParam3;
    }

    public String getDestinationParam4() {
        return destinationParam4;
    }

    public String getDestinationParam5() {
        return destinationParam5;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setSourceParam1(String sourceParam1) {
        this.sourceParam1 = sourceParam1;
    }

    public void setSourceParam2(String sourceParam2) {
        this.sourceParam2 = sourceParam2;
    }

    public void setSourceParam3(String sourceParam3) {
        this.sourceParam3 = sourceParam3;
    }

    public void setSourceParam4(String sourceParam4) {
        this.sourceParam4 = sourceParam4;
    }

    public void setSourceParam5(String sourceParam5) {
        this.sourceParam5 = sourceParam5;
    }

    public void setDestinationParam1(String destinationParam1) {
        this.destinationParam1 = destinationParam1;
    }

    public void setDestinationParam2(String destinationParam2) {
        this.destinationParam2 = destinationParam2;
    }

    public void setDestinationParam3(String destinationParam3) {
        this.destinationParam3 = destinationParam3;
    }

    public void setDestinationParam4(String destinationParam4) {
        this.destinationParam4 = destinationParam4;
    }

    public void setDestinationParam5(String destinationParam5) {
        this.destinationParam5 = destinationParam5;
    }
}
