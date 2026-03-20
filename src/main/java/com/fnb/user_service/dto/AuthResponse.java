package com.fnb.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String token;
    private String username;
    private String message;
}
//Client sends RegisterRequest → Service processes → returns AuthResponse (with JWT)
//Client sends LoginRequest    → Service validates → returns AuthResponse (with JWT)