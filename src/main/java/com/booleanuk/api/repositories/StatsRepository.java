package com.booleanuk.api.repositories;

import com.booleanuk.api.models.Stats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<Stats,Integer> {

}
