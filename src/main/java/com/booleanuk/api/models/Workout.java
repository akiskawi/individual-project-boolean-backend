package com.booleanuk.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "workouts")
@NoArgsConstructor
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    @JsonIgnore
    private User user;

    @Column
    private String name;
    @Column
    @Enumerated
    private EDay day;

    @OneToMany(mappedBy = "workout",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Exercise> exercises;

    public Workout(User user, String name, EDay day) {
        this.user = user;
        this.name = name;
        this.day = day;
        this.exercises=new ArrayList<>();
    }
}


