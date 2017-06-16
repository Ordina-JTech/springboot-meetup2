package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AirplaneController {

    AirplaneRepository airplaneRepo;

    @GetMapping(value = "/airplanes")
    public List<Airplane> getAllAirplanes(){
        return airplaneRepo.findAll();
    }
}
