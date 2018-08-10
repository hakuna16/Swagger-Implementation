package com.rituj.swaggerImpl.controller;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusCheck {

    @RequestMapping(value = "/status", method = RequestMethod.HEAD)
    public int getStatus(){
        return Response.ok().build().getStatus();
    }
}
