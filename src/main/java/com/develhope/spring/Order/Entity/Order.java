package com.develhope.spring.Order.Entity;

import jakarta.persistence.*;

@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(nullable = false)
    private double advance;
    @Column(nullable = false)
    private Boolean isPaid;
    @Column(nullable = false)
    private OrderStatus orderStatus;
//@ManyToOne
//private Vehicle vehicle;


//Allcostructor
//noArgConstructor
//    get e set
//    toString
}