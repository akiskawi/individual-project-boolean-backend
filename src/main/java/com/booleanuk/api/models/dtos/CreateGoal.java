package com.booleanuk.api.models.dtos;

import com.booleanuk.api.models.Goal;
import com.booleanuk.api.models.User;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CreateGoal {
    private double weight;
    private String  bodyFat;

    public Goal toGoal(User user){
        return new Goal(user,weight,bodyFat);
    }
}
