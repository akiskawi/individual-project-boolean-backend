package com.booleanuk.api.controllers;

import com.booleanuk.api.models.Exercise;
import com.booleanuk.api.models.Workout;
import com.booleanuk.api.models.dtos.CreateExercise;
import com.booleanuk.api.repositories.ExerciseRepository;
import com.booleanuk.api.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("users/{userId}/workouts/{workoutId}/exercises")
@CrossOrigin(origins = "http://localhost:5050")
public class ExerciseController {
    @Autowired
    WorkoutService workoutService;
    @Autowired
    ExerciseRepository exerciseRepository;

    @GetMapping
    public List<Exercise> getAllExercises(@PathVariable int userId, @PathVariable int workoutId) {
        return workoutService.getSingleWorkout(userId, workoutId).getExercises();
    }

    @GetMapping("/{id}")
    public Exercise getSingleExercise(@PathVariable int userId, @PathVariable int workoutId, @PathVariable int id) {
        Exercise exercise = exerciseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercise not found"));
        if (exercise.getWorkout().getId() != workoutId || exercise.getWorkout().getUser().getId() != userId)
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "No user have that workout with that exercise:)");
        return exercise;
    }

    @PostMapping
    public Exercise createExercise(@PathVariable int userId, @PathVariable int workoutId,@RequestBody CreateExercise createExercise) {
        Workout workout = workoutService.getSingleWorkout(userId, workoutId);
        return exerciseRepository.save(createExercise.toExercise(workout));
    }
    @PutMapping("/{id}")
    public Exercise updateExercise(@PathVariable int userId, @PathVariable int workoutId,@PathVariable int id,@RequestBody CreateExercise createExercise) {
       Exercise exercise =getSingleExercise(userId, workoutId, id);
        if (createExercise.getName()!=null) exercise.setName(createExercise.getName());
        if (createExercise.getSets()!=0) exercise.setSets(createExercise.getSets());
        if (createExercise.getReps()!=0) exercise.setReps(createExercise.getReps());
        if (createExercise.getRPE()!=0) exercise.setRPE(createExercise.getRPE());
        return exerciseRepository.save(exercise);
    }
    @DeleteMapping("/{id}")
    public Exercise deleteExercise(@PathVariable int userId, @PathVariable int workoutId,@PathVariable int id){
        Exercise exercise =getSingleExercise(userId, workoutId, id);
        exerciseRepository.delete(exercise);
        return exercise;
    }



}
