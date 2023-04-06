package com.example.dto.response;

import lombok.Data;

import java.util.List;
@Data
public class ClientResponseDto {
    private String name;
    private String phoneNumber;
    private String email;
    private List<OrderResponseDto> ordersDto;

}
