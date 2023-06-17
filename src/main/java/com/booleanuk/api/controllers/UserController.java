package com.booleanuk.api.controllers;

import com.booleanuk.api.models.Goal;
import com.booleanuk.api.models.Stats;
import com.booleanuk.api.models.User;
import com.booleanuk.api.models.dtos.CreateUser;
import com.booleanuk.api.repositories.GoalRepository;
import com.booleanuk.api.repositories.StatsRepository;
import com.booleanuk.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    StatsRepository statsRepository;
    @Autowired
    GoalRepository goalRepository;

    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable int id){
        return userRepository.findById(id).get();
    }

    @PostMapping("users")
    public User createUser(@RequestBody CreateUser createUser){
        User tmpUser = new User(createUser.getFirstName(),createUser.getLastName(),createUser.getEmail());
        User user = userRepository.save(tmpUser);
       Stats tmpStats = createUser.getStats().toStats(user);
       Stats stats = statsRepository.save(tmpStats);
        Goal tmpGoal = createUser.getGoal().toGoal(user);
        Goal goal = goalRepository.save(tmpGoal);
        user.setGoal(goal);
        user.setStats(stats);
        return userRepository.save(user);
    }
    @DeleteMapping("users/{id}")
    public User deleteUser(@PathVariable int id){
        User user =getOneUser(id);
        userRepository.delete(user);
        return user;
    }
}
