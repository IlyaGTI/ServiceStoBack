package com.example.exception;

public class OrderSetStatusException extends RuntimeException{
    private static final long serialVersionUID = 1599067826637064209L;

    public static final String EXCEPTION_MESSAGE = "Order with id = (%d), have status CANCELED";

    public OrderSetStatusException(Long id) {super(String.format(EXCEPTION_MESSAGE, id));}
}
