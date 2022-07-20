package com.example.station.service;

import com.example.station.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String embg, String username, String password, String repeatPassword, String name, String surname);
    User loadUserByEmbg(String embg);
}
