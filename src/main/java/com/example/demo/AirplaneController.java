package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/airplanes", method = RequestMethod.POST)
    public void storeAirplane(@RequestBody Airplane airplane) {
        airplaneRepo.save(airplane);
    }
}
