package com.booleanuk.api.repositories;

import com.booleanuk.api.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise,Integer> {
}
