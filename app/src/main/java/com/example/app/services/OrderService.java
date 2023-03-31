package com.example.app.services;

import com.example.model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {

    Order createOrder(Long id, List<Long> servicesId);
}
