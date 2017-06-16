package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
class GreeterController {

    private AppConfig appConfig;

    @GetMapping
    public String greet(){
        return appConfig.getGreeting();
    }
}
