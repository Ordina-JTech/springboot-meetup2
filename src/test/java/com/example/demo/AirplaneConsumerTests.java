package com.example.demo;

import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:test.properties")
public class AirplaneConsumerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void when_called_the_correct_greeting_is_returned(){
        String body = restTemplate.getForObject("/", String.class);
        assertThat(body).isEqualTo("Just checking the walls");
    }

    @Test
    public void httpHeader_contains_the_correct_values() throws Exception {
        HttpHeaders headers = restTemplate.getForEntity("/", String.class).getHeaders();
        assertThat(headers.getContentType().toString()).isEqualTo("text/plain;charset=UTF-8");
    }

    @Test
    public void when_ariplanes_are_saved_they_all_can_be_retreived_as_json(){

        Airplane boeing = new Airplane("Boeing");
        Airplane airbus = new Airplane("Airbus");
        restTemplate.postForObject("/airplanes", boeing, Airplane.class, emptyMap());
        restTemplate.postForObject("/airplanes", airbus, Airplane.class, emptyMap());

        String body = restTemplate.getForObject("/airplanes", String.class);
        assertThat(body).isEqualTo("[{\"name\":\"Boeing\",\"numberOfWings\":2,\"id\":1},{\"name\":\"Airbus\",\"numberOfWings\":2,\"id\":2}]");
    }

    @Test
    public void when_ariplanes_are_saved_they_all_can_be_retreived_as_objects(){

        Airplane boeing = new Airplane("Boeing");
        Airplane airbus = new Airplane("Airbus");
        restTemplate.postForObject("/airplanes", boeing, Airplane.class, emptyMap());
        restTemplate.postForObject("/airplanes", airbus, Airplane.class, emptyMap());

        Airplane[] airplanes = restTemplate.getForObject("/airplanes", Airplane[].class);

        assertThat(airplanes.length).isEqualTo(2);
        assertThat(airplanes[0]).isInstanceOf(Airplane.class);
        assertThat(airplanes[0].getName()).isEqualTo("Boeing");
        assertThat(airplanes[1].getName()).isEqualTo("Airbus");
    }
}
