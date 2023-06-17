package com.booleanuk.api.models.dtos;

import com.booleanuk.api.models.EDay;
import com.booleanuk.api.models.Exercise;
import com.booleanuk.api.models.User;
import com.booleanuk.api.models.Workout;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateWorkout {
    private String name;
    private EDay day;
    private List<CreateExercise> exercises=new ArrayList<>();


    public Workout toWorkout(User user){
        return new Workout(user,name,day);
    }
}
