package com.ConstructionTeam.DatabaseRepository;

import com.ConstructionTeam.DataModels.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQL_CRUDOperator implements DB_CRUDOperator{
    private static Connection connection = new MySQLDBConnector().getDBConnection();



    public ArrayList<User> getUserMailList() throws SQLException, ClassNotFoundException {
        String sqlQuery = "SELECT Name,Email FROM ContactDetails";
        Connection connection = new MySQLDBConnector().getDBConnection();
        ResultSet result = new MySQLResultGetter().getResult(connection,sqlQuery);
        ArrayList<User> userDetails = new ArrayList<User>();
        while (result.next()) {
            User user = new User(result.getString("Name"),result.getString("Email"));
            userDetails.add(user);
        }
        new MySQLConnectionTerminator().closeDBConnection(connection);
        return userDetails;
    }

}
