package com.example.spring_boot_tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
//	@Value("${welcome.message}")
//	private String welcomeMessage;
	
	
	@GetMapping
	public String getHello() {
		return "hello";
	}
	
	

}
