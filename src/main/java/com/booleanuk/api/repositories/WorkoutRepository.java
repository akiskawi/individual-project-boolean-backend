package com.booleanuk.api.repositories;

import com.booleanuk.api.models.User;
import com.booleanuk.api.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout,Integer> {
    List<Workout> findByUser(User user);
    Optional<Workout> findByIdAndUser(int id, User user);

}
