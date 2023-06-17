package com.booleanuk.api.services;

import com.booleanuk.api.models.User;
import com.booleanuk.api.models.dtos.CreateUser;

import java.util.List;

public interface UserService {
   List<User> getAllUsers();
    User getSingleUser(int id);
    User createUser(CreateUser createUser);
    User updateUser(int id, CreateUser createUser);
    User deleteUser(int id);
}
