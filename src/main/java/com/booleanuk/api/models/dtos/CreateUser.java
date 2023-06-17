package com.booleanuk.api.models.dtos;

import com.booleanuk.api.models.Goal;
import com.booleanuk.api.models.Program;
import com.booleanuk.api.models.Stats;
import com.booleanuk.api.models.User;
import lombok.Data;


@Data
public class CreateUser {
    private String firstName;
    private String lastName;
    private String email;
    private CreateStats stats;
    private CreateGoal goal;
}
