package com.rituj.swaggerImpl.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController

@RequestMapping("/books")
@Slf4j
public class Books {

    @RequestMapping(value = "/book/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public String  getBooks(@PathVariable("name") final String name){
        return "Hi from book Apias name: " + name;
    }
}
