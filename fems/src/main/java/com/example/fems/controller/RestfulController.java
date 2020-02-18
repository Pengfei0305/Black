package com.example.fems.controller;


import com.example.fems.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestfulController {

    private CityService cityService;

    @Autowired
    RestfulController(CityService cityService){
        this.cityService = cityService;
    }

    //restful
    @GetMapping("/rest/getCityByIdPath")
    public String restGetCityByIdPath(@PathVariable("id") Integer id){

        String response = cityService.restGetCityByIdPath(id);
        System.out.println(response);
        return response;
    }


//    @GetMapping("/getCityByIdRequestBody")
//    public String getCityByIdRequestBody(@RequestBody Integer id){
//        String response = cityService.getCityByIdRequestBody(id);
//        return response;
//    }
//
//    @GetMapping("/getCityByIdRequestParam")
//    public String getCityByIdRequestParam(@RequestParam("id") Integer id){
//        String response = cityService.getCityByIdRequestParam(id);
//        return response;
//    }

}
