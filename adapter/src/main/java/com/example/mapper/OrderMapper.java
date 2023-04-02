package com.example.mapper;

import com.example.dto.response.OrderResponseDto;
import com.example.dto.response.RepairJobResponseDto;
import com.example.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    @Mapping(source = "status", target = "orderStatus")
    @Mapping(source = "services", target = "jobResponseDtos")
    OrderResponseDto orderToOrderResponseDto(Order order);

    @Named("createOrderResponseDto")
    default OrderResponseDto createOrderResponseDto(Order order, List<RepairJobResponseDto> jobList) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderStatus(order.getStatus());
        orderResponseDto.setJobResponseDtos(jobList);
        return orderResponseDto;
    }

}
