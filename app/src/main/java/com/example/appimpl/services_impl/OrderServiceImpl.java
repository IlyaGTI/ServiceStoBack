package com.example.appimpl.services_impl;

import com.example.app.repositories.OrderRepository;
import com.example.app.repositories.JobRepository;
import com.example.app.services.ClientService;
import com.example.app.services.OrderService;
import com.example.enums.OrderStatus;
import com.example.model.Client;
import com.example.model.Order;
import com.example.model.RepairJob;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ClientService clientService;
    private final OrderRepository orderRepository;
    private final JobRepository jobRepository;

    @Override
    public Order createOrder(Long clientId, List<Long> jobsId) {

        Client client = clientService.findById(clientId);

        List<RepairJob> jobList = jobRepository.findAllById(jobsId);

        Order order = Order.builder()
                .client(client)
                .services(jobList)
                .creationDate(LocalDateTime.now())
                .status(OrderStatus.NEW)
                .totalPrice(calculateTotalPrice(jobList))
                .build();

        return orderRepository.save(order);

    }
    private BigDecimal calculateTotalPrice(List<RepairJob> jobList) {
        return jobList.stream()
                .map(RepairJob::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
