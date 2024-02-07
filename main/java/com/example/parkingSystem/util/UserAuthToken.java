package com.example.parkingSystem.util;

import com.example.parkingSystem.security.UserDetails;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class UserAuthToken extends AbstractAuthenticationToken {
    private final UserDetails userDetails;

    public UserAuthToken(UserDetails userDetails) {
        super(userDetails.getAuthorities());
        this.userDetails = userDetails;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return userDetails.getAuthorities();
    }

    @Override
    public Object getPrincipal() {
        return userDetails;
    }
}
