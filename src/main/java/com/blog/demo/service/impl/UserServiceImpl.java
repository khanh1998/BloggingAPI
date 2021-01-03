package com.blog.demo.service.impl;

import com.blog.demo.exception.EntityNotFoundException;
import com.blog.demo.model.User;
import com.blog.demo.repository.UserRepository;
import com.blog.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new EntityNotFoundException(User.class, "username", username);
        }
        return user;
    }

    @Override
    public User updateUser(String username, User data) {
        User oldUser = userRepository.findUserByUsername(username);
        if (oldUser != null) {
            oldUser.setEmail(data.getEmail());
            oldUser.setAvatar(data.getAvatar());
            oldUser.setFullName(data.getFullName());
            oldUser.setPassword(data.getPassword());
            oldUser.setRoles(data.getRoles());
            return userRepository.save(oldUser);
        }
        return null;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
