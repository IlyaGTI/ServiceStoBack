package com.example.exception;

public class ClientNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1499585868608875877L;
    public static final String NOT_FOUND_BY_ID_MESSAGE = "No client with current id = (%d)";
    public static final String NOT_FOUND_BY_MOBILE_PHONE_MESSAGE = "No client with current mobile phone = (%s)";

    public ClientNotFoundException(Long id) {
        super(String.format(NOT_FOUND_BY_ID_MESSAGE, id));
    }

    public ClientNotFoundException(String mobilePhone) {
        super(String.format(NOT_FOUND_BY_MOBILE_PHONE_MESSAGE, mobilePhone));
    }
}
