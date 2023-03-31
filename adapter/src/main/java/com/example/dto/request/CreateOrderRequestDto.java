package com.example.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequestDto {
    private Long clientId;
    private List<Long> serviceIds;
}
