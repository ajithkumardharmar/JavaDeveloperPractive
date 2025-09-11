package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// If using service discovery (Eureka), use name of delivery service.
// If not, specify full URL with `url = "http://localhost:8890"`
@FeignClient(name = "DELIVERY-SERVICE")
public interface DeliveryClient {

    @GetMapping("/delivery/{deliveryId}")
    String getDeliveryInfo(@PathVariable("deliveryId") Long deliveryId);
}
