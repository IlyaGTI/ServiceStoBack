package com.example.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RepairJobResponseDto {

    private String name;

    private BigDecimal price;
}
