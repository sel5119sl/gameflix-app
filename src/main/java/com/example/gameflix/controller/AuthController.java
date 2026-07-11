package com.example.gameflix.controller;

import com.example.gameflix.service.UserAuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuthController {

    private final UserAuthService userAuthService;

    public AuthController(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> request) {
        String message = userAuthService.register(
                request.get("username"),
                request.get("password")
        );

        return Map.of("message", message);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        String message = userAuthService.login(
                request.get("username"),
                request.get("password")
        );

        return Map.of("message", message);
    }
}