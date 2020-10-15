package com.example.demoUser.dao;
import com.example.demoUser.exception.ResourceNotFoundException;
import com.example.demoUser.model.User;
import com.example.demoUser.repository.UserRepository;

import java.sql.*;
import java.util.*;
import java.util.List;


public class UserDaoImpl implements UserDao {

    UserRepository userRepository;
    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(long id)  {

        return userRepository.findById(id) ;
    }

    @Override
    public void insertUser(User user) {
        userRepository.save(user);

    }

    @Override
    public void updateUser(User user, long id) throws ResourceNotFoundException {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        u.setFirstName(user.getFirstName());
        userRepository.save(user);

    }

    @Override
    public void deleteUser(long id) throws SQLException {
        userRepository.deleteById(id);
    }
}
