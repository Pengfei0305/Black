package com.example.fems.controller;

import com.example.fems.model.City;
import com.example.fems.util.ResultVO;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/feign")
public class HeaderController {

    @GET
    @Path("/getCityByIdHeader")
    //@GetMapping("/feign/getCityByIdHeader")
    public Response getCityByIdHeader(@RequestHeader("id") String id) {
        System.out.println("getCityByIdHeader"+id);
        //ResultVO<City> response = cityService.getCityByIdPath(id);
        return Response.status(200)
                .entity("getCityByIdHeader is called, id : " + id)
                .build();
    }
}
