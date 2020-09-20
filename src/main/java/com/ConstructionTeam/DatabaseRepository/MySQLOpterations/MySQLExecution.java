package com.ConstructionTeam.DatabaseRepository.MySQLOpterations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLExecution {
    private Statement stmt;
    public void executeQuery(Connection conn, String sqlQuery){
        try {
            stmt = conn.createStatement();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        try {
            stmt.executeQuery(sqlQuery);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
