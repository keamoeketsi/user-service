package com.fnb.user_service.service;

import com.fnb.user_service.model.User;

import java.util.Optional;

public interface UserService {

    User registerUser(User user);

    Optional<User> loginUser(String email, String password);
}