package com.ConstructionTeam;

public class Main {

    public static void main(String[] args) {
        /*LogFileReader logFileReader = new LogFileReader();
        logFileReader.logFileReader();*/

        DBConnector connect =new DBConnector();
        connect.getData();
    }
}