package com.develhope.spring.Seller.SERVICE;

import com.develhope.spring.Order.Entity.Order;
import com.develhope.spring.Order.Entity.OrderStatus;
import com.develhope.spring.Order.Repository.OrderRepository;
import com.develhope.spring.Seller.ENTITY.SellerEntity;
import com.develhope.spring.Seller.REPOSITORY.SellerRepository;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import com.develhope.spring.Vehicle.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    OrderRepository orderRepository;

    public Vehicle getVehicleById(Long vehicleId) { //lavorando su veicolo prendo quello
        Optional<Vehicle> vehicleEntityOptional = vehicleRepository.findById(vehicleId);
        if (vehicleEntityOptional.isPresent()) {
            Vehicle vehicleEntity = vehicleEntityOptional.get();
            return vehicleEntity;
        } else {
            return null;
        }
    }

    public Order newOrderVehicle(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) { //nome id che c'è in ORDER
        orderRepository.deleteById(orderId);
    }

    public Order updateOrder(Order updateOrder, Long orderId) {
        Order newUpdateOrder = orderRepository.findById(orderId).orElse(null);
        if (newUpdateOrder != null) {

        }

    }
}

