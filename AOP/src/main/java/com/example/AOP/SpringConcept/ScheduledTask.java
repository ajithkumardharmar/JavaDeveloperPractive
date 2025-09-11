package com.example.AOP.SpringConcept;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Scheduled(fixedRate = 5000)  // Runs every 10 sec
    public void runTask() {
        System.out.println("Running Scheduled Task: " + System.currentTimeMillis());
    }
}

