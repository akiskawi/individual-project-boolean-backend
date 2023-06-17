package com.booleanuk.api.repositories;

import com.booleanuk.api.models.Goal;
import com.booleanuk.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal,Integer> {
    Goal findByUser(User user);
}
