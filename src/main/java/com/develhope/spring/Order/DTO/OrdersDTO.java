package com.develhope.spring.Order.DTO;

import com.develhope.spring.Order.Entity.OrderStatus;
import com.develhope.spring.User.Entity.Users;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {


    private Double advance;

    private Boolean isPaid;

    private OrderStatus orderStatus;

    private Users seller;

    private Users customer;

    private Vehicle vehicle;
}
