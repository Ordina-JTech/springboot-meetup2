package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Airplane{

    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private Integer numberOfWings = 2;

    public Airplane(String name){
        this.name = name;
    }
}
