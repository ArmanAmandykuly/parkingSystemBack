package com.example.parkingSystem.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

@Component
public class JWTDecoder {
    public DecodedJWT decode(String token) {
        try {
            return JWT.require(Algorithm.HMAC256("secret")) //TODO hardcoded
                    .build()
                    .verify(token);
        } catch(Exception e) {
            return null;
        }
    }
}
