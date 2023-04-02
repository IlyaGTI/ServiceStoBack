package com.example.facade;

import com.example.app.services.OrderService;
import com.example.dto.request.UpdateOrderStatusRequestDto;
import com.example.dto.response.OrderResponseDto;
import com.example.mapper.OrderMapper;
import com.example.mapper.RepairJobMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderFacade {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public void createNewOrder(Long id, List<Long> jobsIds) {
        orderService.createOrder(id, jobsIds);
    }

    public void updateOrderStatus(Long orderId, UpdateOrderStatusRequestDto dto) {
        orderService.changeOrderStatus(orderId, dto.getStatus());
    }
    public Optional<OrderResponseDto> getAllOrdersByClientId(Long clientId) {
        return orderService.findAllOrderByClientId(clientId)
                .map(order -> OrderMapper.INSTANCE.createOrderResponseDto(order,
                RepairJobMapper.INSTANCE.repairJobsToRepairJobResponseDtos(order.getServices())));
    }
}
