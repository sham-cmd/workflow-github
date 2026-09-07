package com.practice.e_commerce.service;

import com.practice.e_commerce.entity.User;
import com.practice.e_commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register User
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get User By Id
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // Update User
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // Delete User
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}