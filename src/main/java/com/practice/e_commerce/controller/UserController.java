package com.practice.e_commerce.controller;

import com.practice.e_commerce.entity.User;
import com.practice.e_commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register User
    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get User By Id
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // Update User
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id,
                           @RequestBody User user) {

        user.setId(id);
        return userService.updateUser(user);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {

        userService.deleteUser(id);
        return "User Deleted Successfully";
    }
}