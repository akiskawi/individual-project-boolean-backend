package com.booleanuk.api.models.daos;

import com.booleanuk.api.models.Goal;
import com.booleanuk.api.models.Stats;
import com.booleanuk.api.models.User;
import com.booleanuk.api.models.Workout;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDaoView extends UserDao {
    private String email;
    private Stats stats;
    private Goal goals;
    private List<Workout> workouts;

    public UserDaoView(User user) {
        super(user);
        email= user.getEmail();
        stats = user.getStats();
        goals = user.getGoal();
        workouts = user.getWorkouts();
    }
}
