package com.develhope.spring.Order.Service;

import com.develhope.spring.Order.Entity.OrderStatus;
import com.develhope.spring.Order.Entity.Orders;
import com.develhope.spring.Order.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Orders newOrderVehicle(Orders order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) { //nome id che c'è in ORDER
        orderRepository.deleteById(orderId);
    }

    public Orders updateOrder(Orders updateOrder, Long orderId) { //MODIFICARE UN ORDINE CREATO
        Orders newUpdateOrder = orderRepository.findById(orderId).orElse(null);
        if (newUpdateOrder != null) {
            newUpdateOrder.setAdvance(updateOrder.getAdvance()); //setAdvance trovata in entity degli ordini
            newUpdateOrder.setPaid(updateOrder.getPaid());
            newUpdateOrder.setOrderStatus(updateOrder.getOrderStatus());
            newUpdateOrder.setVehicle(updateOrder.getVehicle());
            newUpdateOrder.setBuyer(updateOrder.getBuyer());
            newUpdateOrder.setSellerEntity(updateOrder.getSellerEntity());
            return orderRepository.save(newUpdateOrder);
        }
        return null;
    }


    public OrderStatus getOrderStatus(Long id) { //prima faccio query in ORDER REPO
        return orderRepository.getOrderStatus(id);
    }


    public Orders updateStatusOrder(Orders updateStatusOrder, Long id) {
        Orders newUpdateOrder = orderRepository.findById(id).orElse(null);
        if (newUpdateOrder != null) {
            newUpdateOrder.setOrderStatus(updateStatusOrder.getOrderStatus());
            return orderRepository.save(newUpdateOrder);
        }
        return null;
    }

    public List<Orders> getAllOrderByStatus (OrderStatus orderStatus){
        return orderRepository.getAllOrderByStatus(orderStatus);
    }
 }
