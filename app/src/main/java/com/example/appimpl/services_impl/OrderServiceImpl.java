package com.example.appimpl.services_impl;

import com.example.app.services.OrderService;
import com.example.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(Order order) {
        return null;
    }
}
