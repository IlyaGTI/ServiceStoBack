package com.example.enums;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public enum OrderStatus {

    NEW("Новый"),
    IN_PROGRESS("Выполняется"),
    DONE("Завершен"),
    CANCELED("Отменен");

    private String name;

}
