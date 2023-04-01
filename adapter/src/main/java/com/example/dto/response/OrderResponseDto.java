package com.example.dto.response;

import com.example.enums.OrderStatus;
import lombok.Data;


import java.util.List;
@Data
public class OrderResponseDto {

    private OrderStatus orderStatus;

    private List<RepairJobResponseDto> jobResponseDtos;


}
