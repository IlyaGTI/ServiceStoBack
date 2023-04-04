package com.example.facade;

import com.example.app.services.OrderService;
import com.example.dto.request.UpdateOrderStatusRequestDto;
import com.example.dto.response.OrderResponseDto;
import com.example.enums.OrderStatus;
import com.example.mapper.OrderMapper;
import com.example.mapper.RepairJobMapper;
import com.example.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderFacade {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public void createNewOrder(Long id, List<Long> jobsIds) {
        orderService.createOrder(id, jobsIds);
    }

    public void canceledOrder(Long orderId) {
        orderService.canceledOrder(orderId);
    }
    public void finishOrder(Long orderId) {
        orderService.canceledOrder(orderId);
    }
    public Optional<OrderResponseDto> getAllOrdersByClientId(Long clientId) {
        return orderService.findAllOrderByClientId(clientId)
                .map(order -> OrderMapper.INSTANCE.createOrderResponseDto(order,
                RepairJobMapper.INSTANCE.repairJobsToRepairJobResponseDtos(order.getServices())));
    }

    public Optional<OrderResponseDto> getAllCompletedOrdersByTwoDate(LocalDateTime startDate, LocalDateTime finishDate){
        return orderService.findDoneOrderByTwoDate(startDate, finishDate)
                .map(order -> OrderMapper.INSTANCE.createOrderResponseDto(order,
                        RepairJobMapper.INSTANCE.repairJobsToRepairJobResponseDtos(order.getServices())));
    }

    public List<OrderResponseDto> getAllOrderByOrderStatus(OrderStatus orderStatus){
        return orderService.findAllOrderByOrderStatus(orderStatus).stream()
                .map(order -> OrderMapper.INSTANCE.createOrderResponseDto(order,
                        RepairJobMapper.INSTANCE.repairJobsToRepairJobResponseDtos(order.getServices())))
                .collect(Collectors.toList());
    }
}
