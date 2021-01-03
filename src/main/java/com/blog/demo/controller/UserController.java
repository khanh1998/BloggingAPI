package com.blog.demo.controller;

import com.blog.demo.model.User;
import com.blog.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PutMapping("{username}")
    public User updateUserByUsername(@RequestBody User user, @PathVariable String username) {
        return userService.updateUser(username, user);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
