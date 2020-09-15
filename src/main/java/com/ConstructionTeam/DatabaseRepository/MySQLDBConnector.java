package com.ConstructionTeam.DatabaseRepository;

import java.sql.*;

public class MySQLDBConnector {
    private String url ="jdbc:mysql://localhost:3306/Users";
    private String username = "root";
    private String password = "17013";
    private Connection conn;
    private Statement stmt;
    private ResultSet result;

    public Connection getDBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            conn= DriverManager.getConnection(url, username, password);
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
        return conn;
    }

    public ResultSet getResult (Connection conn, String sqlQuery){
        try {
            stmt = conn.createStatement();
        } catch (SQLException sqlException) {
            System.out.println(sqlQuery);;
        }
        try {
            result = stmt.executeQuery(sqlQuery);
        } catch (SQLException sqlException) {
            System.out.println(sqlException);;
        }
        return result;
    }

    public void closeDBConnection(Connection connection) {

        try {
            connection.close();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }
}
