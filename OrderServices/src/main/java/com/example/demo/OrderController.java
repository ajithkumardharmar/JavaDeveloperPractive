package com.example.demo;

import com.example.demo.feign.DeliveryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
	
    private final DeliveryClient deliveryClient;
    
    @Autowired
    Environment environment ;

    public OrderController(DeliveryClient deliveryClient) {
        this.deliveryClient = deliveryClient;
    }

    @GetMapping("/orders/{orderId}")
    public String getOrder(@PathVariable Long orderId) {
        try {
        	System.out.println(environment.getProperty("local.server.port"));
            String deliveryInfo = deliveryClient.getDeliveryInfo(orderId);
            return "Order Placed Successfully! Order ID: " + orderId +
                    ", Delivery Info: " + deliveryInfo;
        } catch (Exception e) {
            return "Failed to fetch delivery info: " + e.getMessage();
        }
    }
}
