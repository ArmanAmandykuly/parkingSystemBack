package com.example.parkingSystem.security;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;

    private String password;
}
