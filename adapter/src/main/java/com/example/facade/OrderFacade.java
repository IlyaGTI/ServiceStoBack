package com.example.facade;

import com.example.app.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class OrderFacade {
    private final OrderService orderService;
    public void createNewOrder(Long id, List<Long> jobsIds) {
        orderService.createOrder(id, jobsIds);
    }
}
