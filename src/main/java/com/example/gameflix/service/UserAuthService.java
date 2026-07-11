package com.example.gameflix.service;

public interface UserAuthService {

    String register(String username, String password);

    String login(String username, String password);
}
