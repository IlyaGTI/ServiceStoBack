package com.example.app.services;

import com.example.enums.OrderStatus;
import com.example.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order createOrder(Long id, List<Long> servicesId);

    Order findOrderById(Long id);

    Optional<Order> findAllOrderByClientId(Long clientId);

    Order changeOrderStatus(Long id, OrderStatus status);
}
