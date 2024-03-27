package com.develhope.spring.Order.Entity;

import com.develhope.spring.User.Entity.Users;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(nullable = false)
    private Double advance;
    @Column(nullable = false)
    private Boolean isPaid;
    @Column(nullable = false)
    private OrderStatus orderStatus;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Users seller;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Users customer;
    @OneToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", advance=" + advance +
                ", isPaid=" + isPaid +
                ", orderStatus=" + orderStatus +
                ", seller=" + seller +
                ", customer=" + customer +
                ", vehicle=" + vehicle +
                '}';
    }
}