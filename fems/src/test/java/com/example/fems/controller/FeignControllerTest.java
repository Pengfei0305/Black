package com.example.fems.controller;

import com.example.fems.service.CityService;
import com.example.fems.util.ResultVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class FeignControllerTest {

    @Mock
    CityService cityService;

    FeignController feignController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        feignController = new FeignController(cityService);
    }


    @Test
    void getCityByIdPathNotReturnNull() {

        when(cityService.getCityByIdPath(1)).thenReturn(new ResultVO<>());
        assertNotNull(feignController.getCityByIdPath(1));
    }

}