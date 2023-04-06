package com.example.mapper;

import com.example.dto.request.NewClientRequestDto;
import com.example.dto.response.ClientResponseDto;
import com.example.dto.response.OrderResponseDto;
import com.example.model.Client;
import com.example.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {OrderMapper.class})
public interface ClientMapper {
    Client newClientRequestDtoToClient(NewClientRequestDto requestDto);

    @Mapping(source = "orders", target = "ordersDto", qualifiedByName = "mapToOrderResponseDtos")
    ClientResponseDto clientToClientResponseDto(Client client);

    @Named("mapToOrderResponseDtos")
    static List<OrderResponseDto> mapToOrderResponseDtos(List<Order> orders) {
        return orders.stream()
                .map(order -> OrderMapper.INSTANCE.createOrderResponseDto(order, RepairJobMapper.INSTANCE.repairJobsToRepairJobResponseDtos(order.getServices())))
                .collect(Collectors.toList());
    }
}
