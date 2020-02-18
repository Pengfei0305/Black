package com.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CityController.class)
@ExtendWith(SpringExtension.class)
class CityControllerTest {

    private MockMvc mockMvc;

    @SpyBean
    private CityController controller;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    void getCityById_Returns200() throws Exception {
        mockMvc.perform(get("/getCityByIdPath/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getCityById_ReturnsError() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/getCityByIdPath/{id}", 100))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals("{\"code\":1,\"msg\":\"Can not find city by this id\",\"data\":null}",mvcResult.getResponse().getContentAsString());
    }
}