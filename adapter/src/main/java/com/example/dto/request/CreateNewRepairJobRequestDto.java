package com.example.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateNewRepairJobRequestDto {

    @NotBlank
    private String name;

    private BigDecimal price;
}
