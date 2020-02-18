package com.example.fems.service;

import com.example.fems.feign.CityClient;
import com.example.fems.model.City;
import com.example.fems.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CityService {

    private CityClient cityClient;

    @Autowired
    public CityService(CityClient cityClient){
        this.cityClient = cityClient;
    }

    public ResultVO<City> getCityByIdPath(Integer id){
        return cityClient.getCityByIdPath(id);
    }

    public String restGetCityByIdPath(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8081/restGetCityByIdPath",String.class);
        return response;
    }

    public String getCityByIdRequestBody(String id){
        return cityClient.getCityByIdRequestBody(id);
    }

    public ResultVO<City> getCityByIdRequestParam(Integer id){
        return cityClient.getCityByIdRequestParam(id);
    }

}
