package com.example.exception;

import java.io.Serial;

public class OrderNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 555349233365040925L;

    public static final String NOT_FOUND_BY_ID = "No Order witch current id = (%d)";

    public OrderNotFoundException(Long id) {super(String.format(NOT_FOUND_BY_ID, id));}
}
