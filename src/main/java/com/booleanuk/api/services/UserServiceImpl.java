package com.booleanuk.api.services;

import com.booleanuk.api.models.Goal;
import com.booleanuk.api.models.Stats;
import com.booleanuk.api.models.User;
import com.booleanuk.api.models.dtos.CreateUser;
import com.booleanuk.api.repositories.GoalRepository;
import com.booleanuk.api.repositories.StatsRepository;
import com.booleanuk.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    StatsRepository statsRepository;
    @Autowired
    GoalRepository goalRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getSingleUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not in database"));
    }

    @Override
    public User createUser(CreateUser createUser) {
        User tmpUser = new User(createUser.getFirstName(), createUser.getLastName(), createUser.getEmail());
        User user = userRepository.save(tmpUser);
        Stats stats = new Stats();
        if (createUser.getStats() != null) {
            Stats tmpStats = createUser.getStats().toStats(user);
            stats = statsRepository.save(tmpStats);
        }
        Goal goal= new Goal();
        if (createUser.getGoal() != null) {
            Goal tmpGoal = createUser.getGoal().toGoal(user);
            goal = goalRepository.save(tmpGoal);

        }
        user.setGoal(goal);
        user.setStats(stats);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, CreateUser newUser) {
        User tmp = getSingleUser(id);
        if (newUser.getFirstName() != null) tmp.setEmail(newUser.getEmail());
        if (newUser.getLastName() != null) tmp.setLastName(newUser.getLastName());
        if (newUser.getEmail() != null) {
            if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Email already exists");
            }
            tmp.setEmail(newUser.getEmail());
        }
        return userRepository.save(tmp);
    }

    @Override
    public User deleteUser(int id) {
        User user = getSingleUser(id);
        userRepository.delete(user);
        return user;
    }
}
