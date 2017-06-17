package com.example.demo;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(AirplaneController.class)
public class AirplaneControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AirplaneRepository airplaneRepo;

    @Test
    public void showAllAirplanesTest() throws Exception {

        Airplane airbus = new Airplane("AIRBUS");
        Airplane boeing = new Airplane("BOEING");

        given(airplaneRepo.findAll()).willReturn(Arrays.asList(airbus, boeing));

        mvc.perform(get("/airplanes").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].name", is(airbus.getName())))
            .andExpect(jsonPath("$[1].name", is(boeing.getName())));
    }
}
