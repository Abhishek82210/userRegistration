package com.example.registration_system.service;

import com.example.registration_system.dto.UserRegistrationDto;
import com.example.registration_system.model.User;
import com.example.registration_system.exception.UserAlreadyExistsException;
import com.example.registration_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserRegistrationDto registrationDto) {
        // Check email existence
        if (userRepository.existsByEmail(registrationDto.getEmail())) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        // Check username existence
        if (userRepository.existsByUsername(registrationDto.getUsername())) {
            throw new UserAlreadyExistsException("Username already exists");
        }

        // Create and save user
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword()); // Encryption needed in real apps
        return userRepository.save(user);
    }
}