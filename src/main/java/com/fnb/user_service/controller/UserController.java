package com.fnb.user_service.controller;

import com.fnb.user_service.dto.LoginRequest;
import com.fnb.user_service.dto.RegisterRequest;
import com.fnb.user_service.model.User;
import com.fnb.user_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // 🔹 Register a new user
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // raw password, will be hashed in service

        User registeredUser = service.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    // 🔹 Login user by username & password
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        Optional<User> user = service.loginUser(request.getUsername(), request.getPassword());

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}