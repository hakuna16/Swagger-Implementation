package com.rituj.swaggerImpl.exception;

/**
 * Runtime exception denoting invalid data.
 * Valid cases for this exception are incorrect input data, Json parsing failure due to incorrect data,
 * date parsing failure due to incorrect data etc.
 */
public class InvalidDataException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public InvalidDataException() {
        super();
    }
    
    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
