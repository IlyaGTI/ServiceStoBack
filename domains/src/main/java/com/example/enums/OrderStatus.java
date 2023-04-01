package com.example.enums;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum OrderStatus {

    NEW("Новый"),
    IN_PROGRESS("Выполняется"),
    DONE("Завершен"),
    CANCELED("Отменен");

    private String name;

}
