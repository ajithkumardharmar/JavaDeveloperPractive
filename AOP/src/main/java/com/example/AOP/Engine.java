package com.example.AOP;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;




@Component
public class Engine {

    public Engine() {
        System.out.println("⚙️ Engine Object Created...");
    }

    @PostConstruct  // Runs after bean creation
    public void init() {
        System.out.println("✅ Engine is ready to use...");
    }

    @PreDestroy  // Runs before bean destruction
    public void destroy() {
        System.out.println("❌ Engine is shutting down...");
    }
}

