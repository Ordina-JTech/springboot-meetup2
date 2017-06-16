package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Airplane{

    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private Integer numberOfWings = 2;
}
