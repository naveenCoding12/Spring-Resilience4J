package com.naveen.serviceB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/b")
public class ServiceBController {

    @GetMapping
    public String serviceB() {
        return "Service B is calling from service A";
    }
}
