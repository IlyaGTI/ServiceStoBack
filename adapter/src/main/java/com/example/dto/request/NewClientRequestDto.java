package com.example.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NewClientRequestDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String email;
    @NotBlank
    private String address;

    private String notes;
}
