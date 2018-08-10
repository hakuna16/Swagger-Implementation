package com.rituj.swaggerImpl.domain;

import lombok.Data;

@Data
public class Book {
    private Integer bookId;
    private String bookName;
    private String bookAuthour;
    private String bookQuantity;
}
