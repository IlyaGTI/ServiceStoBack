package com.example.appimpl.services_impl;

import com.example.app.repositories.OrderRepository;
import com.example.app.repositories.JobRepository;
import com.example.app.services.ClientService;
import com.example.app.services.OrderService;
import com.example.enums.OrderStatus;
import com.example.exception.ClientNotFoundException;
import com.example.exception.OrderCancellationException;
import com.example.exception.OrderSetStatusException;
import com.example.exception.OrderNotFoundException;
import com.example.model.Client;
import com.example.model.Order;
import com.example.model.RepairJob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final ClientService clientService;
    private final OrderRepository orderRepository;
    private final JobRepository jobRepository;

    @Override
    @Transactional(readOnly = true)
    public Order findOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Order> findAllOrderByClientId(Long clientId) {
        return Optional.ofNullable(orderRepository.findAllByClientId(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Order> findDoneOrderByTwoDate(LocalDateTime startDate, LocalDateTime endDate) {
        return orderRepository.findDoneOrdersByTwoDates(startDate, endDate);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAllOrderByOrderStatus(OrderStatus orderStatus) {
        return orderRepository.findAllByStatus(orderStatus);
    }

    @Override
    @Transactional
    public void canceledOrder(Long id) {
        Order order = findOrderById(id);

        if (order.getStatus() == OrderStatus.DONE) {
            throw new OrderCancellationException(id);
        }

        order.setStatus(OrderStatus.CANCELED);
        orderRepository.save(order);
        log.info("Order with id = ({}) successfully canceled", id);
    }

    @Override
    @Transactional
    public void finishOrder(Long id) {
        Order order = findOrderById(id);

        if (order.getStatus() == OrderStatus.CANCELED) {
            throw new OrderSetStatusException(id);
        }

        order.setStatus(OrderStatus.DONE);
        orderRepository.save(order);
        log.info("Order with id = ({}) successfully finish", id);

    }

    @Override
    @Transactional
    public void setInProgress(Long id) {
        Order order = findOrderById(id);

        if (order.getStatus() == OrderStatus.CANCELED) {
            throw new OrderSetStatusException(id);
        }

        order.setStatus(OrderStatus.IN_PROGRESS);
        orderRepository.save(order);
        log.info("Order with id = ({}) set status In Progress ", id);
    }

    @Override
    @Transactional
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

        orderRepository.save(order);
        log.info("Order for client with id = ({}) successfully created", clientId);

        return order;

    }

    private BigDecimal calculateTotalPrice(List<RepairJob> jobList) {
        return jobList.stream()
                .map(RepairJob::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
