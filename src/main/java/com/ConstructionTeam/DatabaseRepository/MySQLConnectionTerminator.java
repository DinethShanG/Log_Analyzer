package com.ConstructionTeam.DatabaseRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLConnectionTerminator {
    public void closeDBConnection(Connection connection) {

        try {
            connection.close();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }
}
