package com.example.parkingSystem.services;

import com.example.parkingSystem.dto.UserDTO;
import com.example.parkingSystem.model.entities.User;
import com.example.parkingSystem.model.repositories.UserRepository;
import com.example.parkingSystem.utils.exceptions.UserNotFoundException;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@Data
public class UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public User getById(long userId) throws Exception{
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }

        return userOptional.get();
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
}
