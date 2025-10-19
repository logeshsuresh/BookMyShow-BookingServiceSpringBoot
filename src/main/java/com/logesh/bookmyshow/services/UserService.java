package com.logesh.bookmyshow.services;

import com.logesh.bookmyshow.entities.User;

public interface UserService {
    User findUserById(Long userId);
}
