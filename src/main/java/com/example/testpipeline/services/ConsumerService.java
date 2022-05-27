package com.example.testpipeline.services;

import com.example.testpipeline.models.HealthMetric;
import com.example.testpipeline.models.HeartData;
import com.example.testpipeline.repositories.BloodOxygenRepository;
import com.example.testpipeline.repositories.HeartMonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    HeartMonitorRepository heartMonitorRepository;

    @Autowired
    BloodOxygenRepository bloodOxygenRepository;

    public void saveData(HeartData Health){

    }
}
