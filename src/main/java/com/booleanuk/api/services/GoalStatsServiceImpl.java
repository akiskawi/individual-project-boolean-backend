package com.booleanuk.api.services;

import com.booleanuk.api.models.Goal;
import com.booleanuk.api.models.Stats;
import com.booleanuk.api.models.dtos.CreateGoal;
import com.booleanuk.api.models.dtos.CreateStats;
import com.booleanuk.api.repositories.GoalRepository;
import com.booleanuk.api.repositories.StatsRepository;
import com.booleanuk.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalStatsServiceImpl implements GoalStatsService {
    @Autowired
    UserService userService;
    @Autowired
    GoalRepository goalRepository;
    @Autowired
    StatsRepository statsRepository;

    @Override
    public Goal getGoals(int id) {
        return userService.getSingleUser(id).getGoal();
    }

    @Override
    public Goal updateGoals(int id, CreateGoal newGoals) {
        Goal oldGoals = getGoals(id);
        if (newGoals.getWeight() != 0) oldGoals.setWeight(newGoals.getWeight());
        if (newGoals.getBodyFat() != null) oldGoals.setBodyFat(newGoals.getBodyFat());
        return goalRepository.save(oldGoals);
    }

    @Override
    public Stats getStats(int id) {
        return userService.getSingleUser(id).getStats();
    }

    @Override
    public Stats updateStats(int id, CreateStats newStats) {
        Stats oldStats = getStats(id);
        if (newStats.getBodyFat() != null) oldStats.setBodyFat(newStats.getBodyFat());
        if (newStats.getHeight() != 0) oldStats.setHeight(newStats.getHeight());
        if (newStats.getWeight() != 0) oldStats.setWeight(newStats.getWeight());
        return statsRepository.save(oldStats);
    }
}
