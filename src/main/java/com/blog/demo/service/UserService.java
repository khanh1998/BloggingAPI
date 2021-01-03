package com.blog.demo.service;

import com.blog.demo.model.User;

public interface UserService {
    User createUser(User user);
    User getUserByUsername(String username);
    User updateUser(String username, User user);
}
