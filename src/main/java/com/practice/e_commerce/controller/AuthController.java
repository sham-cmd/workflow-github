package com.practice.e_commerce.controller;

import com.practice.e_commerce.dto.LoginRequest;
import com.practice.e_commerce.dto.LoginResponse;
import com.practice.e_commerce.dto.RegisterRequest;
import com.practice.e_commerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Register
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    // Login
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}