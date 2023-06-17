package com.booleanuk.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "program_id",nullable = false)
    @JsonIgnore
    private User user;

    @Column
    private String name;
    @Column
    @Enumerated
    private EDay day;

    @OneToMany(mappedBy = "workout",cascade = CascadeType.ALL)
    private List<Exercise> exercises;
}


