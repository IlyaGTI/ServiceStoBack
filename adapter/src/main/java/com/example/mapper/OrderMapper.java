package com.example.mapper;

import com.example.dto.response.OrderResponseDto;
import com.example.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    //TODO Исправить первым делом
    @Mapping(source = "status", target = "orderStatus")
    @Mapping(source = "services", target = "jobResponseDtos")
    OrderResponseDto toDto(Order order);

}
