package com.example.testpipeline.services;

import com.example.testpipeline.models.BloodOxygenData;
import com.example.testpipeline.models.HeartData;
import com.example.testpipeline.repositories.BloodOxygenRepository;
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

    int mockPatientId[]={2,3,4,5};

    //@Scheduled(cron="0 * * * * *")
   /* public Runnable medicalData() {
        Date currentDate= new Date(System.currentTimeMillis());
        return () -> {
            HeartDataGen(currentDate);
            OxygenDataGen(currentDate);

        };
    }*/
    @Scheduled(cron="0 * * * * *")
    @Async
    public void  HeartDataGen(){
        Date currentDate= new Date(System.currentTimeMillis());
        for(int patientId:mockPatientId) {
            int bps = ThreadLocalRandom.current().nextInt(70, 99);
            HeartData heartData = new HeartData(bps,patientId,currentDate);
            heartMonitorRepository.save(heartData);
        }

    }
    @Scheduled(cron="0 * * * * *")
    @Async
    public void OxygenDataGen(){
        Date currentDate= new Date(System.currentTimeMillis());
        for(int patientId:mockPatientId) {
            int bloodOxygen = ThreadLocalRandom.current().nextInt(30, 99);
            BloodOxygenData bloodOxygenData = new BloodOxygenData(bloodOxygen, patientId, currentDate);
            bloodOxygenRepository.save(bloodOxygenData);
        }
    }

}



//produce data through scheduler at random times/fixed interval --done
//persist the produced data to db--almost done
//pull the complete or subset of data when requested---not done

//1 ms to produce data
//another to return data when requested->either of a particular patient or all the patients of a particular doctor--not done
