package com.example.fems.service;

import com.example.fems.feign.CityClient;
import com.example.fems.model.City;
import com.example.fems.util.ResultVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CityServiceTest {

    CityService cityService;

    @Mock
    CityClient cityClient;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.cityService = new CityService(cityClient);
    }

    @Test
    void getCityByIdPath() {
        when(cityClient.getCityByIdPath(1)).thenReturn(new ResultVO<City>());
        assertNotNull(cityService.getCityByIdPath(1));
    }
}