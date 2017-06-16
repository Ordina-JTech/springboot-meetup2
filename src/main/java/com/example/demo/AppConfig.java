package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(value = "app")
@Getter @Setter
class AppConfig{

    String greeting;
}
