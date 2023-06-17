package com.booleanuk.api.services;

import com.booleanuk.api.models.Workout;
import com.booleanuk.api.models.dtos.CreateWorkout;

import java.util.List;

public interface WorkoutService {
    Workout getSingleWorkout(int userId,int id);
    List<Workout> getAllWorkouts(int userId);
    Workout createWorkout(int userId, CreateWorkout createWorkout);
    Workout updateWorkout(int userId,int id, CreateWorkout createWorkout);
    Workout deleteWorkout(int userId,int id);
}
