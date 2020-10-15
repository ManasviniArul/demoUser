package com.example.demoUser.dao;

import com.example.demoUser.exception.ResourceNotFoundException;
import com.example.demoUser.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public interface UserDao  {
    List<User> getUsers() throws SQLException;

    Optional<User> getUser(long id) throws SQLException;


    void insertUser(User user) throws SQLException;


    void updateUser(User user, long id) throws SQLException, ResourceNotFoundException;


    void deleteUser(long id) throws SQLException;


}

