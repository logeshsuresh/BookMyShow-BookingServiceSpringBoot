package com.logesh.bookmyshow.services.impl;

import com.logesh.bookmyshow.entities.User;
import com.logesh.bookmyshow.repositories.UserRepository;
import com.logesh.bookmyshow.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long userId) {
        return this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException(String.format("UserId: {} not found", userId)));
    }

}
