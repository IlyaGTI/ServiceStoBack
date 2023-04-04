package com.example.exception;

public class OrderCancellationException extends RuntimeException{
    private static final long serialVersionUID = -50267021836264030L;

    public static final String EXCEPTION_MESSAGE = "Order with id = (%d), have status DONE";

    public OrderCancellationException(Long id) {super(String.format(EXCEPTION_MESSAGE, id));}
}
