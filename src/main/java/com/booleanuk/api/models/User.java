package com.booleanuk.api.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
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

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
