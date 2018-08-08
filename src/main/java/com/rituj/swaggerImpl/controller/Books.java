package com.rituj.swaggerImpl.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/books")
public class Books {

    @RequestMapping(value = "/book/{name}", method = RequestMethod.GET)
    public String  getBooks(@PathVariable("name") final String name){
        return "Hi from book Apias name: " + name;
    }
}
