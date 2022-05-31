package com.example.testpipeline.repositories;

import com.example.testpipeline.models.BloodOxygenData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BloodOxygenRepository extends JpaRepository<BloodOxygenData,Integer> {
    @Modifying
    @Query(
            value = "DELETE FROM blood_oxygen_data where `timestamp`<(NOW()-INTERVAL 9 MINUTE)",
            nativeQuery = true
    )
    public void deleteBefore();
}
