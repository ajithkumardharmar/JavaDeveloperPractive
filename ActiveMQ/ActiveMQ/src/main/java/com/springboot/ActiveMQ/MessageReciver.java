package com.springboot.ActiveMQ;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReciver {
	
	@JmsListener(destination = "test-queue")
	public void reciveMessage(String message) {
		System.out.println("Recived message : "+message);
	}
	
}
