package com.ConstructionTeam;

import java.sql.*;


public class DBConnector {
    public Connection connection;
    private Statement statement;
    public ResultSet resultSet;

    //create constructor
    public DBConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/constructionteamdb", "root", "");
            statement = connection.createStatement();

        } catch (Exception ex) {
            System.out.println();
        }
    }

    public void getData() {
        try {

            String query = "select * from email";
            resultSet = statement.executeQuery(query);
            System.out.println("Email from Database");
            while (resultSet.next()) {
                String result = resultSet.getString("email");
                System.out.println(result);

            }
        } catch (Exception ex) {
            System.out.println();
        }

    }
}
