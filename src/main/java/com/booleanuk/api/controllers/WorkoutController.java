package com.booleanuk.api.controllers;

import com.booleanuk.api.models.Workout;
import com.booleanuk.api.models.daos.WorkoutDao;
import com.booleanuk.api.models.dtos.CreateWorkout;
import com.booleanuk.api.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/{userId}/workouts")
@CrossOrigin(origins = "http://localhost:5050")
public class WorkoutController {
    @Autowired
    WorkoutService workoutService;


    @GetMapping
    public List<Workout> getAllWorkouts(@PathVariable int userId) {
        return workoutService.getAllWorkouts(userId);
    }

    @GetMapping("/{id}")
    public WorkoutDao getSingleWorkoutDao(@PathVariable int userId, @PathVariable int id) {
        return workoutService.getSingleWorkoutDao(userId, id);
    }
    @GetMapping("/{id}/all")
    public Workout getSingleWorkout(@PathVariable int userId, @PathVariable int id) {
        return workoutService.getSingleWorkout(userId, id);
    }


    @PostMapping
    public Workout createWorkout(@PathVariable int userId, @RequestBody CreateWorkout createWorkout) {
        return workoutService.createWorkout(userId, createWorkout);
    }

    @PutMapping("/{id}")
    public WorkoutDao updateWorkout(@PathVariable int userId, @PathVariable int id, @RequestBody CreateWorkout createWorkout) {
        return workoutService.updateWorkout(userId, id, createWorkout);
    }

    @DeleteMapping("/{id}")
    public Workout updateWorkout(@PathVariable int userId, @PathVariable int id) {
        return workoutService.deleteWorkout(userId, id);
    }


}
