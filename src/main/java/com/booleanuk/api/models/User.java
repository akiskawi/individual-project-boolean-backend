package com.booleanuk.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stats_id",referencedColumnName = "id")
    private Stats stats;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goal_id",referencedColumnName = "id")
    private Goal goal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "program_id",referencedColumnName = "id")
    private Program program;

}
