package com.example.parkingSystem.security;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginResponse {
    private final String message;
}
