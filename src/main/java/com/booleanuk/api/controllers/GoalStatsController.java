package com.booleanuk.api.controllers;

import com.booleanuk.api.models.Goal;
import com.booleanuk.api.models.Stats;
import com.booleanuk.api.models.dtos.CreateGoal;
import com.booleanuk.api.models.dtos.CreateStats;
import com.booleanuk.api.repositories.GoalRepository;
import com.booleanuk.api.repositories.StatsRepository;
import com.booleanuk.api.repositories.UserRepository;
import com.booleanuk.api.services.GoalStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users/{userId}")
@CrossOrigin(origins = "http://localhost:5050")
public class GoalStatsController {

    @Autowired
    GoalStatsService goalStatsService;




    @GetMapping("/goals")
    public Goal getGoalsOfUser(@PathVariable int userId) {
        return goalStatsService.getGoals(userId);
    }

    @PutMapping("/goals")
    public Goal updateGoals(@PathVariable int userId, @RequestBody CreateGoal goals) {
        return goalStatsService.updateGoals(userId,goals);
    }

    @GetMapping("/stats")
    public Stats getStatsOfUser(@PathVariable int userId) {
        return goalStatsService.getStats(userId);
    }

    @PutMapping("/stats")
    public Stats updateStats(@PathVariable int userId, @RequestBody CreateStats stats) {
        return goalStatsService.updateStats(userId,stats);
    }

}
