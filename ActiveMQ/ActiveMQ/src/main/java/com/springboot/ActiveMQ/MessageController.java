package com.springboot.ActiveMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	@Autowired
	private MessageSender sender;
	
	@GetMapping("/send")
	public String send(@RequestParam String msg) {
		sender.sendMessage("test-queue", msg);
		return "Message sent to ActiveMQ queue!";
	}
	

}
