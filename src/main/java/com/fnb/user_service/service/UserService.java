package com.fnb.user_service.service;

import com.fnb.user_service.dto.AuthResponse;
import com.fnb.user_service.dto.LoginRequest;
import com.fnb.user_service.dto.RegisterRequest;

public interface UserService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}