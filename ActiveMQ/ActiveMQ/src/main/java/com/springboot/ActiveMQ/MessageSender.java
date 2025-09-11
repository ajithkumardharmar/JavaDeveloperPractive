package com.springboot.ActiveMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(String queue,String message) {
		jmsTemplate.convertAndSend(queue, message);
		System.out.println(" Message sent : "+message);
	}
}
