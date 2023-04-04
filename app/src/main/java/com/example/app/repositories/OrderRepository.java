package com.example.app.repositories;

import com.example.enums.OrderStatus;
import com.example.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT * FROM orders WHERE client_id = :clientId",
            nativeQuery = true)
    Optional<Order> findAllByClientId(@Param("clientId") Long clientId);

    @Query(value = "SELECT * FROM orders WHERE order_status = 'DONE' AND completion_date BETWEEN :startDate AND :endDate",
             nativeQuery = true)
    Optional<Order> findDoneOrdersByTwoDates(@Param("startDate")LocalDateTime startDate,
                                             @Param("endDate")LocalDateTime endDate);

    List<Order> findAllByStatus(OrderStatus orderStatus);
}
