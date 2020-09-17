package com.ConstructionTeam.DatabaseRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLResultGetter {
    private Statement stmt;
    private ResultSet result;
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
}
