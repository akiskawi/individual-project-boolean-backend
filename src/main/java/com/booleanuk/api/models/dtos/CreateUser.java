package com.booleanuk.api.models.dtos;

import lombok.Data;


@Data
public class CreateUser {
    private String firstName;
    private String lastName;
    private String email;
    private CreateStats stats;
    private CreateGoal goals;
}
