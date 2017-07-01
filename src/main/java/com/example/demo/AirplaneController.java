package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AirplaneController {

    private AirplaneRepository airplaneRepo;

    @GetMapping(value = "/airplanes")
    public List<Airplane> getAllAirplanes(){
        return airplaneRepo.findAll();
    }

    @PostMapping(value = "/airplanes")
    public void storeAirplane(@RequestBody Airplane airplane) {
        airplaneRepo.save(airplane);
    }

    @DeleteMapping(value = "/airplanes")
    public void deleteAllAirplane() {
        airplaneRepo.deleteAll();
    }
}
