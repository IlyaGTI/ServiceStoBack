package com.example.app.services;

import com.example.model.Order;
import org.aspectj.weaver.ast.Or;

public interface OrderService {

    Order createOrder(Order order);
}
