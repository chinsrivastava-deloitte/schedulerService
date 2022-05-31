package com.example.testpipeline.repositories;

import com.example.testpipeline.models.BloodPressure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BloodPressureDataRepository extends JpaRepository<BloodPressure,Integer> {
    @Modifying
    @Query(
            value = "DELETE FROM blood_pressure where `timestamp`<(NOW()-INTERVAL 9 MINUTE)",
            nativeQuery = true
    )
    public void deleteBefore();
}

