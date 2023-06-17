package com.booleanuk.api.controllers;

import com.booleanuk.api.models.User;
import com.booleanuk.api.models.dtos.CreateUser;
import com.booleanuk.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable int id) {
        return userService.getSingleUser(id);
    }

    @PostMapping
    public User createUser(@RequestBody CreateUser createUser) {
        return userService.createUser(createUser);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody CreateUser newUser) {
        return userService.updateUser(id,newUser);
    }
}
