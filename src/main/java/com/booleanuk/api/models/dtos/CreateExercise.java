package com.booleanuk.api.models.dtos;

import com.booleanuk.api.models.Exercise;
import com.booleanuk.api.models.Workout;
import lombok.Data;

@Data
public class CreateExercise {
    private String name;
    private int sets;
    private int reps;
    private int RPE;

    public Exercise toExercise(Workout workout){
        return new Exercise(workout,name,sets,reps,RPE);
    }
}
