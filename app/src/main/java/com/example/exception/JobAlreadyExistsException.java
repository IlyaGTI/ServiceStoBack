package com.example.exception;

public class JobAlreadyExistsException extends RuntimeException{

    private static final long serialVersionUID = 325380682852828863L;

    public static final String EXCEPTION_MESSAGE = "Job with name = (%d), already exists";

    public JobAlreadyExistsException(String name) {super(String.format(EXCEPTION_MESSAGE, name));}

}
