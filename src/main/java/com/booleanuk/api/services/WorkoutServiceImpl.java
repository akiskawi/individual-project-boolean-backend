package com.booleanuk.api.services;

import com.booleanuk.api.models.Exercise;
import com.booleanuk.api.models.User;
import com.booleanuk.api.models.Workout;
import com.booleanuk.api.models.dtos.CreateWorkout;
import com.booleanuk.api.repositories.ExerciseRepository;
import com.booleanuk.api.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class WorkoutServiceImpl implements WorkoutService {

    @Autowired
    UserService userService;
    @Autowired
    WorkoutRepository workoutRepository;
    @Autowired
    ExerciseRepository exerciseRepository;
    @Override
    public Workout getSingleWorkout(int userId, int id) {
        User user = userService.getSingleUser(userId);
        return workoutRepository.findByIdAndUser(id,user)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Workout not found"));
    }

    @Override
    public List<Workout> getAllWorkouts(int userId) {
        User user = userService.getSingleUser(userId);
        return workoutRepository.findByUser(user);

    }

    @Override
    public Workout createWorkout(int userId, CreateWorkout createWorkout) {
        User user = userService.getSingleUser(userId);
        Workout theWorkout = workoutRepository.save(createWorkout.toWorkout(user));
        List<Exercise> tmpExercises = createWorkout.getExercises().stream().map(x -> x.toExercise(theWorkout)).toList();
        List<Exercise> theExercises = exerciseRepository.saveAll(tmpExercises);
        theWorkout.setExercises(theExercises);
        return workoutRepository.save(theWorkout);
    }

    @Override
    public Workout updateWorkout(int userId, int id, CreateWorkout createWorkout) {
        Workout workout = getSingleWorkout(userId, id);
        if (createWorkout.getName() != null) workout.setName(createWorkout.getName());
        if (createWorkout.getDay() != null) workout.setDay(createWorkout.getDay());
        return workoutRepository.save(workout);
    }

    @Override
    public Workout deleteWorkout(int userId, int id) {
        Workout workout = getSingleWorkout(userId, id);
        workoutRepository.delete(workout);
        return workout;
    }
}
