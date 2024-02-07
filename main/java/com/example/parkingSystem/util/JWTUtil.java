package com.example.parkingSystem.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JWTUtil {
    public String issue(String username, List<String> roles) {
        return JWT.create()
                .withSubject(username)
                .withClaim("a", roles)
                .sign(Algorithm.HMAC256("secret")); //TODO the secret must be configured
    }
}
