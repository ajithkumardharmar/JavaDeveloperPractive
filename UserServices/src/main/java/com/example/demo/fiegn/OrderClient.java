package com.example.demo.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ORDER-SERVICE")
public interface OrderClient {
	
//	@GetMapping("/orders/{orderId}")
//    String getOrder(@PathVariable Long orderId);
	@GetMapping("/orders/{userId}")
    String getOrderDetails(@PathVariable("userId") Long userId);
}
