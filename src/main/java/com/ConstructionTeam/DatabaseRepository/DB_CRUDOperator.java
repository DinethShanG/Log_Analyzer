package com.ConstructionTeam.DatabaseRepository;

import com.ConstructionTeam.DataModels.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DB_CRUDOperator {
    ArrayList<User> getUserMailList() throws SQLException, ClassNotFoundException;
    void addUser(String name,String mail);
}
