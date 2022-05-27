package com.example.testpipeline.repositories;

import com.example.testpipeline.models.HeartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartMonitorRepository extends JpaRepository<HeartData, Integer> {
}
