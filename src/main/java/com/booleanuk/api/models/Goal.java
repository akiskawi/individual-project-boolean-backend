package com.booleanuk.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "goal")
    @JsonIgnore
    private User user;
    @Column
    private double weight;
    @Column
    private String  bodyFat;

    public Goal(User user, double weight, String bodyFat) {
        this.user = user;
        this.weight = weight;
        this.bodyFat = bodyFat;
    }
}
