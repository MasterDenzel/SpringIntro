package com.denzelcode.springfsintro.controller;

import com.denzelcode.springfsintro.model.GreetingDTO;
import com.denzelcode.springfsintro.services.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("api/v1/greeting")
    public GreetingDTO getGreeting(){
        return greetingService.getGreeting();
    }
}
