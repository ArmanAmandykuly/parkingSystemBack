package com.example.parkingSystem.services;

import com.example.parkingSystem.model.entities.User;
import com.example.parkingSystem.model.repositories.UserRepository;
import com.example.parkingSystem.security.LoginRequest;
import com.example.parkingSystem.security.LoginResponse;
import com.example.parkingSystem.security.UpdateRequest;
import com.example.parkingSystem.security.UserDetails;
import com.example.parkingSystem.util.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JWTUtil jwtUtil;

    private final AuthenticationManager authManager;

    private final UserRepository userRepository;

    public LoginResponse attemptLogin(LoginRequest request) {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList();

            String token = jwtUtil.issue(request.getUsername(), roles);

            return LoginResponse.builder()
                    .message(token)
                    .build();


    }

    public void register(User user) throws RuntimeException {
        if(userRepository.findByName(user.getName()).isPresent()) {
            throw new RuntimeException("Account with such an username already exists");
        }

        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("REGISTERED");

        userRepository.save(user);
    }

    public ResponseEntity<String> update(UpdateRequest request) throws RuntimeException {
        Optional<User> userOptional = userRepository.findByName(request.getUsername());

        if(userOptional.isEmpty()) {
            throw new RuntimeException("Account with such an username doesn't exist");
        }

        return ResponseEntity.ok("Account's password is successfully updated");
    }
}
