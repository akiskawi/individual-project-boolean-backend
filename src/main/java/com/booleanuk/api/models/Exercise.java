package com.booleanuk.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "exercises")
@NoArgsConstructor
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

    public Exercise(Workout workout, String name, int sets, int reps, int RPE) {
        this.workout = workout;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.RPE = RPE;
    }
}
