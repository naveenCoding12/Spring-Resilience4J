package com.naveen.serviceA.controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/a")
public class ServiceAController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8081/";

    private  static final String SERVICE_NAME = "ServiceA";
    @GetMapping
    @RateLimiter(name = SERVICE_NAME, fallbackMethod = "serviceFallBack")
    public String getMessage() {
        return restTemplate.getForObject(BASE_URL + "b", String.class);
    }

    public String serviceFallBack(Throwable throwable) {
        return "Rate limit exceeded. Please try again later. Reason: " + throwable.getMessage();
    }


}
