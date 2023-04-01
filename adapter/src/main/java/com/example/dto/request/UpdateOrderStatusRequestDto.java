package com.example.dto.request;

import com.example.enums.OrderStatus;
import lombok.Data;

@Data
public class UpdateOrderStatusRequestDto {
    private OrderStatus status;
}
