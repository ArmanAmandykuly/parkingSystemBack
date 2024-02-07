package com.example.parkingSystem.controllers;

import com.example.parkingSystem.dto.UserDTO;
import com.example.parkingSystem.model.entities.User;
import com.example.parkingSystem.services.AuthService;
import com.example.parkingSystem.security.LoginRequest;
import com.example.parkingSystem.security.LoginResponse;
import com.example.parkingSystem.security.UpdateRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    private final ModelMapper modelMapper;

    private final PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO dto) throws RuntimeException {
        try{
            User user = modelMapper.map(dto, User.class);
            user.setPassword(encoder.encode(user.getPassword()));

            authService.register(user);
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(this.getClass());
            logger.info(dto.toString());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Registered");
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) throws RuntimeException{
        return authService.attemptLogin(request);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody UpdateRequest request) throws RuntimeException {
        return authService.update(request);
    }

    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return ResponseEntity.ok("OK");
    }
}
