package com.ConstructionTeam.DatabaseRepository.MySQLOpterations;

import java.sql.*;

public class MySQLDBConnector {
    private final String url ="jdbc:mysql://localhost:3306/Users";
    private final String username = "root";
    private final String password = "17013";
    private final Connection conn;

    public Connection getDBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySql Database Connector not founded");
        }
        try {
            conn= DriverManager.getConnection(url, username, password);
        } catch (SQLException sqlException) {
            System.out.println("MySQL Database Authentication Failed");
            System.exit(0);
        }
        return conn;
    }

}
