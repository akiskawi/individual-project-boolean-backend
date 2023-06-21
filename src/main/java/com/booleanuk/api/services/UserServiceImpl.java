package com.booleanuk.api.services;

import com.booleanuk.api.models.Goal;
import com.booleanuk.api.models.Stats;
import com.booleanuk.api.models.User;
import com.booleanuk.api.models.daos.UserDao;
import com.booleanuk.api.models.daos.UserDaoView;
import com.booleanuk.api.models.dtos.CreateUser;
import com.booleanuk.api.repositories.GoalRepository;
import com.booleanuk.api.repositories.StatsRepository;
import com.booleanuk.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    StatsRepository statsRepository;
    @Autowired
    GoalRepository goalRepository;

    @Override
    public List<UserDao> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDao::new).toList();
    }

    @Override
    public UserDaoView getSingleUser(int id) {
        User user = getUserById(id);
        return new UserDaoView(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not in database"));
    }

    @Override
    public UserDao createUser(CreateUser createUser) {
        User tmpUser = new User(createUser.getFirstName(), createUser.getLastName(), createUser.getEmail());
        User user = userRepository.save(tmpUser);
        Stats stats = new Stats();
        if (createUser.getStats() != null) {
            Stats tmpStats = createUser.getStats().toStats(user);
            stats = statsRepository.save(tmpStats);
        }
        Goal goal = new Goal();
        if (createUser.getGoals() != null) {
            Goal tmpGoal = createUser.getGoals().toGoal(user);
            goal = goalRepository.save(tmpGoal);

        }
        user.setGoal(goal);
        user.setStats(stats);
        User theUser = userRepository.save(user);
        return new UserDao(theUser);
    }

    @Override
    public UserDao updateUser(int id, CreateUser newUser) {
        User tmp = getUserById(id);
        if (newUser.getFirstName() != null) tmp.setFirstName(newUser.getFirstName());
        if (newUser.getLastName() != null) tmp.setLastName(newUser.getLastName());
        if (newUser.getEmail() != null) {
            if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
                if (!Objects.equals(tmp.getEmail(),newUser.getEmail())) {
                    throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Email already exists");
                }
            }
            tmp.setEmail(newUser.getEmail());
        }
        return new UserDao(userRepository.save(tmp));
    }

    @Override
    public User deleteUser(int id) {
        User user = getUserById(id);
        userRepository.delete(user);
        return user;
    }
}
