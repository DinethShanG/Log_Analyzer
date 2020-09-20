package com.ConstructionTeam.DatabaseRepository;

import com.ConstructionTeam.DataModels.User;
import com.ConstructionTeam.DatabaseRepository.MySQLOpterations.MySQLConnectionTerminator;
import com.ConstructionTeam.DatabaseRepository.MySQLOpterations.MySQLDBConnector;
import com.ConstructionTeam.DatabaseRepository.MySQLOpterations.MySQLExecution;
import com.ConstructionTeam.DatabaseRepository.MySQLOpterations.MySQLResultGetter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQL_CRUDOperator implements DB_CRUDOperator{
    private Connection connection = new MySQLDBConnector().getDBConnection();
    private String sqlQuery;
    public ArrayList<User> getUserMailList() throws SQLException {
        ArrayList<User> userDetails = new ArrayList<>();

        sqlQuery = "SELECT Name,Email FROM ContactDetails";

        ResultSet result = new MySQLResultGetter().getResult(connection,sqlQuery);

        while (result.next()) {

            User user = new User(result.getString("Name"),result.getString("Email"));
            userDetails.add(user);

        }

        new MySQLConnectionTerminator().closeDBConnection(connection);

        return userDetails;
    }

    @Override
    public void addUser(String name, String mail) {
        sqlQuery = "INSERT INTO `Users`.`ContactDetails` (`Name`, `Email`) VALUES ('"+name+"', '"+mail+"')";
        new MySQLExecution().executeQuery(connection, sqlQuery);

        new MySQLConnectionTerminator().closeDBConnection(connection);
    }

}
