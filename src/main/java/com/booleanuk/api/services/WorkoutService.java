package com.booleanuk.api.services;

import com.booleanuk.api.models.Workout;
import com.booleanuk.api.models.daos.WorkoutDao;
import com.booleanuk.api.models.dtos.CreateWorkout;

import java.util.List;

public interface WorkoutService {
    WorkoutDao getSingleWorkoutDao(int userId, int id);
    Workout getSingleWorkout(int userId, int id);
    List<Workout> getAllWorkouts(int userId);
    Workout createWorkout(int userId, CreateWorkout createWorkout);
    WorkoutDao updateWorkout(int userId,int id, CreateWorkout createWorkout);
    Workout deleteWorkout(int userId,int id);
}
