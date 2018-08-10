package com.rituj.swaggerImpl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rituj.swaggerImpl.domain.Book;
import com.rituj.swaggerImpl.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
    public List<Book> getBookById(final Integer id) {
        return bookRepository.getBookById(id);
    }
    
    public Book addBook(Book book){
        return bookRepository.addBook(book);
    }
}
