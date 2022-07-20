package com.example.station.service.impl;

import com.example.station.model.User;
import com.example.station.model.exceptions.InvalidArgumentsException;
import com.example.station.model.exceptions.InvalidUserCredentialsException;
import com.example.station.repository.jpa.UserRepository;
import com.example.station.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findUserByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }
}
