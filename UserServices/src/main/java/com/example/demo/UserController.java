package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.fiegn.OrderClient;

@RestController
public class UserController {

    private final OrderClient orderClient;

    public UserController(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    @GetMapping("/users/{userId}")
    public String getUser(@PathVariable Long userId) {
        String orderDetails = orderClient.getOrderDetails(userId);
        return "Successfully login user " + userId + " Order Details: " + orderDetails;
    }
}
