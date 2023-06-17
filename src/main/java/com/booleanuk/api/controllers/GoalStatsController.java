package com.booleanuk.api.controllers;

import com.booleanuk.api.models.Goal;
import com.booleanuk.api.models.Stats;
import com.booleanuk.api.models.dtos.ReqGoal;
import com.booleanuk.api.models.dtos.ReqStat;
import com.booleanuk.api.repositories.GoalRepository;
import com.booleanuk.api.repositories.StatsRepository;
import com.booleanuk.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users/{userId}")
public class GoalStatsController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    GoalRepository goalRepository;
    @Autowired
    StatsRepository statsRepository;


    @GetMapping("/goals")
    public Goal getGoalsOfUser(@PathVariable int userId) {
        return userRepository.findById(userId).get().getGoal();
    }

    @PutMapping("/goals")
    public Goal updateGoals(@PathVariable int userId, @RequestBody ReqGoal goals) {
        Goal oldGoals = getGoalsOfUser(userId);
        if (goals.getWeight() != 0) oldGoals.setWeight(goals.getWeight());
        if (goals.getBodyFat() != null) oldGoals.setBodyFat(goals.getBodyFat());
        return goalRepository.save(oldGoals);
    }

    @GetMapping("/stats")
    public Stats getStatsOfUser(@PathVariable int userId) {
        return userRepository.findById(userId).get().getStats();
    }

    @PutMapping("/stats")
    public Stats updateStats(@PathVariable int userId, @RequestBody ReqStat stats) {
        Stats oldStats = getStatsOfUser(userId);
        if (stats.getBodyFat() != null) oldStats.setBodyFat(stats.getBodyFat());
        if (stats.getHeight() != 0) oldStats.setHeight(stats.getHeight());
        if (stats.getWeight() != 0) oldStats.setWeight(stats.getWeight());
        return statsRepository.save(oldStats);
    }

}
