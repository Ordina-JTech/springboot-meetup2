package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class DemoApplication {

	public static void main(String[] args) {
			SpringApplication.run(DemoApplication.class, args);
	}
}

