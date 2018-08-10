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
public class BookController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public String  getBooks(@PathVariable("name") final String name){
        log.info("Getting book information of: {}", name);
        return null;
    }
}
