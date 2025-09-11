package com.ajith.SpringSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String greet(HttpServletRequest httpreRequest) {
		return "Welcome to AkTech "+httpreRequest.getSession().getId();
	}
}
