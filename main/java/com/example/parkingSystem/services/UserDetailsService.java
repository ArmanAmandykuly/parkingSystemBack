package com.example.parkingSystem.services;

import com.example.parkingSystem.model.entities.User;
import com.example.parkingSystem.model.repositories.UserRepository;
import com.example.parkingSystem.security.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByName(username);

        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Username not found");
        }

        User user = optionalUser.get();

        return UserDetails.builder()
                .username(username)
                .password(user.getPassword())
                .authorities(List.of(new SimpleGrantedAuthority("User")))
                .build();
    }
}
