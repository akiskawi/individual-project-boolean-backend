package com.booleanuk.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "workout_id",nullable = false)
    @JsonIgnore
    private Workout workout;

    @Column
    private String name;
    @Column
    private int sets;
    @Column
    private int reps;
    @Column
    private int RPE;


}
