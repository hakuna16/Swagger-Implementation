package com.rituj.swaggerImpl.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rituj.swaggerImpl.domain.Book;
import com.rituj.swaggerImpl.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<Book> getBooks(@PathVariable("id") final Integer id) {
        log.info("Getting book information of: {}", id);
        return bookService.getBookById(id);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
    public Book addBook(Book book) {
        log.info("Adding book information");
        return bookService.addBook(book);
    }
    
    @RequestMapping(value = "/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON)
    public Book updateBook(Book book) {
        log.info("Adding book information");
        return bookService.addBook(book);
    }
}
