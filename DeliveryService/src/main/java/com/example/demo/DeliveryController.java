package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {
	@GetMapping("delivery/{deliveryId}")
	public String getDeliveryInfo(@PathVariable Long deliveryId) {
		return "Yet to delivery "+ deliveryId;
	}
}
