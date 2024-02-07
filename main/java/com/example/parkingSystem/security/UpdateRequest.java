package com.example.parkingSystem.security;

import lombok.Data;

@Data
public class UpdateRequest {
    private String username;

    private String password;

    private String newPassword;
}
