package com.example.gameflix.service;

import com.example.gameflix.model.User;
import com.example.gameflix.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserAuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String register(String username, String password) {
        //null and blank validation check
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            return "Username and password are required";
        }

        if (userRepository.existsByUsername(username)) {
            return "Username already exists";
        }

        String hashedPassword = passwordEncoder.encode(password);
        User user = new User(username, hashedPassword);
        userRepository.save(user);

        return "User registered successfully";
    }

    @Override
    public String login(String username, String password) {
        //null and blank validation check
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            return "Invalid username or password";
        }

        return userRepository.findByUsername(username)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .map(user -> "Login successful")
                .orElse("Invalid username or password");
    }
}