package com.practice.e_commerce.service;

import com.practice.e_commerce.dto.LoginRequest;
import com.practice.e_commerce.dto.LoginResponse;
import com.practice.e_commerce.dto.RegisterRequest;
import com.practice.e_commerce.entity.User;
import com.practice.e_commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Register User
    public String register(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Encrypt Password
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Default Role
        user.setRole("USER");

        userRepository.save(user);

        return "User Registered Successfully";
    }

    // Login User
    public LoginResponse login(LoginRequest request) {

        LoginResponse response = new LoginResponse();

        User user = userRepository.findByEmail(request.getEmail()).orElse(null);

        if (user == null) {
            response.setMessage("User Not Found");
            return response;
        }

        // Compare encrypted password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            response.setMessage("Invalid Password");
            return response;
        }

        response.setMessage("Login Successful");
        response.setToken("JWT_TOKEN_WILL_BE_CREATED_LATER");

        return response;
    }
}