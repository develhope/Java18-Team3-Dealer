package com.develhope.spring.Order.Repository;

import com.develhope.spring.Order.Entity.OrderStatus;
import com.develhope.spring.Order.Entity.Orders;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT OrderStatus FROM Orders WHERE OrderId = ?1", nativeQuery = true) //prende id che passiamo con = ?1
    OrderStatus getOrderStatus(Long id);

    @Query(value = "SELCT * FROM Orders WHERE OrderStatus = ?1", nativeQuery = true) //prende tutti gli ordini
    List<Orders> getAllOrderByStatus(OrderStatus orderStatus);
}
