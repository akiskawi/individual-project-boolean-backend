package com.booleanuk.api.services;

import com.booleanuk.api.models.User;
import com.booleanuk.api.models.daos.UserDao;
import com.booleanuk.api.models.daos.UserDaoView;
import com.booleanuk.api.models.dtos.CreateUser;

import java.util.List;

public interface UserService {
   List<UserDao> getAllUsers();
    UserDaoView getSingleUser(int id);
    UserDao createUser(CreateUser createUser);
    User updateUser(int id, CreateUser createUser);
    User deleteUser(int id);
    User getUserById(int id);
}
