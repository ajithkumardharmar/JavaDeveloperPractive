package com.example.AOP.SpringConcept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.AOP.BS6Engine;

@Component
public class Car {
	
	
    private BS6Engine engine;

    @Autowired
    public Car(@Qualifier("petrolEngine") BS6Engine engine) {  // Specify which bean to use
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("🚗 Car is running...");
    }
}
