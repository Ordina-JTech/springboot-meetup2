package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AirplaneRepositoryTest {

    @Autowired
    AirplaneRepository airplaneRepo;

    @Test
    public void testFindByName(){

        Airplane boeing = new Airplane();
        boeing.setName("BOEING");
        airplaneRepo.save(boeing);

        Airplane result = airplaneRepo.findByName("BOEING");

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(boeing.getName());
        assertThat(result.getNumberOfWings()).isEqualTo(boeing.getNumberOfWings());
    }
}
