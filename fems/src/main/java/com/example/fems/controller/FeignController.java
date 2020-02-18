package com.example.fems.controller;


import com.example.fems.model.City;
import com.example.fems.model.Id;
import com.example.fems.service.CityService;
import com.example.fems.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

@RestController
public class FeignController {

    private CityService cityService;

    @Autowired
    FeignController(CityService cityService){
        this.cityService = cityService;
    }

    //feign
    @GetMapping("/feign/getCityByIdPath/{id}")
    public ResultVO<City> getCityByIdPath(@PathVariable("id") Integer id){
        ResultVO<City> response = cityService.getCityByIdPath(id);
        return response;
    }

    @GetMapping("/feign/getCityByIdHeader1")
    //@GetMapping("/feign/getCityByIdHeader")
    public ResponseEntity<ResultVO<City>> getCityByIdHeader1(@RequestHeader("id") Integer id) {
        System.out.println("getCityByIdHeader"+id);
        ResultVO<City> response = cityService.getCityByIdPath(id);
        return new ResponseEntity<ResultVO<City>>(response, HttpStatus.OK);
    }

    @PostMapping("/getCityByIdRequestBody")
    public Integer getCityByIdRequestBody(@RequestBody Integer id){
        Integer response = 11;
                //cityService.getCityByIdRequestBody(id);
        return response;
    }

    @PostMapping("/test")
    public Id test(@RequestBody Id id){
        String response = cityService.getCityByIdRequestBody(id.getId());
        id.setResponse(response);
        return id;
    }

    @GetMapping("/getCityByIdRequestParam")
    public ResultVO<City> getCityByIdRequestParam(@RequestParam("id") Integer id){
        ResultVO<City> response = cityService.getCityByIdRequestParam(id);
        return response;
    }

}
