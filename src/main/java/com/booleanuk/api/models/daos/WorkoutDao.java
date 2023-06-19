package com.booleanuk.api.models.daos;

import com.booleanuk.api.models.EDay;
import com.booleanuk.api.models.Workout;
import lombok.Data;

@Data
public class WorkoutDao {
    private int id;
    private String name;
    private EDay day;

    public WorkoutDao(Workout workout) {
        id=workout.getId();
        name=workout.getName();
        day=workout.getDay();

    }
}
