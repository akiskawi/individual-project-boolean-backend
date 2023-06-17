package com.booleanuk.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="programs")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "program")
    @JsonIgnore
    private User user;
    @Column
    @Enumerated
    private ETrainingType trainingType;

    @OneToMany(mappedBy = "program",cascade = CascadeType.ALL)
    private List<Workout> workouts;
}
