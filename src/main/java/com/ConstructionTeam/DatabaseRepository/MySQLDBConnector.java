package com.ConstructionTeam.DatabaseRepository;

import java.sql.*;

public class MySQLDBConnector {
    private String url ="jdbc:mysql://localhost:3306/Users";
    private String username = "root";
    private String password = "";
    private Connection conn;

    public Connection getDBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySql Database Connector not founded");
        }
        try {
            conn= DriverManager.getConnection(url, username, password);
        } catch (SQLException sqlException) {
            System.out.println("MySQL Database Authentication Failed");
        }
        return conn;
    }

}
