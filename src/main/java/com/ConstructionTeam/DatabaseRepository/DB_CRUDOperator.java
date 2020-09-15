package com.ConstructionTeam.DatabaseRepository;

import com.ConstructionTeam.DataModels.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DB_CRUDOperator {
    void addUser(String name, String email);
    void deleteUser(String name);
    ArrayList<User> getUserMailList() throws SQLException, ClassNotFoundException;
    void updateUser(String name);
}
