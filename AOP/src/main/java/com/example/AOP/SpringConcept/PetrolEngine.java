package com.example.AOP.SpringConcept;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.AOP.BS6Engine;

//@Primary
@Component("petrolEngine")  // Bean name: petrolEngine
public class PetrolEngine extends BS6Engine{

	public PetrolEngine() {
		super("petrol");
	}

}
