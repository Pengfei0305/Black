package com.example.fems.feign;

import com.example.fems.model.City;
import com.example.fems.util.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//FOR LOCAL DEV
@FeignClient(value = "city-crud", url="http://localhost:8081/")

//@FeignClient(name = "${clients.authors.name}")
public interface CityClient {

    @GetMapping("/getCityByIdPath/{id}")
    ResultVO<City> getCityByIdPath(@PathVariable("id") Integer id);

    @PostMapping("/getCityByIdRequestBody")
    String getCityByIdRequestBody(@RequestBody String id);

    @GetMapping("/getCityByIdRequestParam")
    ResultVO<City> getCityByIdRequestParam(@RequestParam("id") Integer id);

}
