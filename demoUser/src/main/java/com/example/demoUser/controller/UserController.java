package com.example.demoUser.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


import com.example.demoUser.dao.UserDao;
import com.example.demoUser.dao.UserDaoImpl;
import com.example.demoUser.exception.ResourceNotFoundException;
import com.example.demoUser.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Users")
public class UserController {
    //@Autowired
    UserDao userDao;
    public UserController() {

        userDao = new UserDaoImpl();

    }
    //UserDaoImpl userDao;
    @GetMapping("/GetAllUsers")
    public List<User> getAllUsers() throws SQLException {
         return userDao.getUsers();
    }

    @GetMapping("/GetOneUser/{id}")
    public Optional<User> getOneUser(@PathVariable(value = "id") Long userId) throws SQLException {
        return userDao.getUser(userId);
    }

    @PostMapping("/CreateUser")
    public void createUser(@RequestBody User user) throws SQLException {
        userDao.insertUser(user);

    }

    @DeleteMapping("/DeleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id") Long userId) throws SQLException {

         userDao.deleteUser(userId);

    }

    @PutMapping("/UpdateUser/{id}")
    public void updateEmployee(@PathVariable(value = "id") Long userId, @RequestBody User user) throws SQLException, ResourceNotFoundException {
        userDao.updateUser(user, userId);

    }
}
