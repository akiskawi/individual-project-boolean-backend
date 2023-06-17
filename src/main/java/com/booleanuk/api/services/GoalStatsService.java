package com.booleanuk.api.services;

import com.booleanuk.api.models.Goal;
import com.booleanuk.api.models.Stats;
import com.booleanuk.api.models.dtos.CreateGoal;
import com.booleanuk.api.models.dtos.CreateStats;

public interface GoalStatsService {

    Goal getGoals(int id);
    Goal updateGoals(int id, CreateGoal newGoals);
    Stats getStats(int id);
    Stats updateStats(int id, CreateStats newStats);
}
