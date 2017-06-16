package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreeterController {

    @GetMapping
    public String greet(){
        return "Hallo allemaal!";
    }
}
