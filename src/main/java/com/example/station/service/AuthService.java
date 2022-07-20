package com.example.station.service;

import com.example.station.model.User;

public interface AuthService {
    User login(String username, String password);

}
