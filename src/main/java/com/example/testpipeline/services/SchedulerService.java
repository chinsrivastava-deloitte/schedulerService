package com.example.testpipeline.services;

import com.example.testpipeline.models.BloodOxygenData;
import com.example.testpipeline.models.BloodPressure;
import com.example.testpipeline.models.HeartData;
import com.example.testpipeline.repositories.BloodOxygenRepository;
import com.example.testpipeline.repositories.BloodPressureDataRepository;
import com.example.testpipeline.repositories.HeartMonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class SchedulerService {

    @Autowired
    HeartMonitorRepository heartMonitorRepository;
    @Autowired
    BloodOxygenRepository bloodOxygenRepository;
    @Autowired
    BloodPressureDataRepository bloodPressureDataRepository;

    int mockPatientId[]={2,3,4,5};

    /**
     * runs a scheduler to generate heart rate data at a interval of 1 minutes
     */
    @Scheduled(cron="0 * * * * *")
    @Async
    public void  HeartDataGen(){
        heartMonitorRepository.deleteBefore();
        Date currentDate= new Date(System.currentTimeMillis());
        for(int patientId:mockPatientId) {
            int bps = ThreadLocalRandom.current().nextInt(70, 99);
            HeartData heartData = new HeartData(bps,patientId,currentDate);
            heartMonitorRepository.save(heartData);
        }

    }

    /**
     * runs a scheduler to generate blood oxygen data at the interval of 1 minute
     */
    @Scheduled(cron="0 * * * * *")
    @Async
    public void OxygenDataGen(){
        bloodOxygenRepository.deleteBefore();
        Date currentDate= new Date(System.currentTimeMillis());
        for(int patientId:mockPatientId) {
            int bloodOxygen = ThreadLocalRandom.current().nextInt(30, 99);
            BloodOxygenData bloodOxygenData = new BloodOxygenData(bloodOxygen, patientId, currentDate);
            bloodOxygenRepository.save(bloodOxygenData);
        }
    }

    /**
     * runs a scheduler to generate systolic and diastolic blood pressure at an interval of 1 min
     */
    @Scheduled(cron="0 * * * * *")
    @Async
    public void BloodPressureDataGen(){
        bloodPressureDataRepository.deleteBefore();
        Date currentDate= new Date(System.currentTimeMillis());
        for(int patientId:mockPatientId) {
            int systolic = ThreadLocalRandom.current().nextInt(70, 99);
            int diastolic= ThreadLocalRandom.current().nextInt(118, 150);
            BloodPressure bloodPressure = new BloodPressure(systolic,diastolic, patientId, currentDate);
            bloodPressureDataRepository.save(bloodPressure);
        }
    }


}
