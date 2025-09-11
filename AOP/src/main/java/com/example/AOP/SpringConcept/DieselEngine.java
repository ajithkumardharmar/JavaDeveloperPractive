package com.example.AOP.SpringConcept;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.AOP.BS6Engine;
//If we use @Component and bean name  ("dieselEngine") we call specific class using @Qualifier("dieselEngine") 

//@Primary // If @Primary annotation was used for default bean if no specific bean called then this bean class will execute
@Component("dieselEngine")  // Bean name: dieselEngine
public class DieselEngine extends BS6Engine {
	
	public DieselEngine() {
		super("diesel");
	}
}
