package com.booleanuk.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "stats")
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "stats")
    @JsonIgnore
    private User user;
    @Column
    private double weight;
    @Column
    private double height;
    @Column
    private String bodyFat;

    public Stats(User user, double weight, double height, String bodyFat) {
        this.user = user;
        this.weight = weight;
        this.height = height;
        this.bodyFat = bodyFat;
    }
}
