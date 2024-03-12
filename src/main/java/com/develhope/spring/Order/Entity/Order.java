package com.develhope.spring.Order.Entity;

import com.develhope.spring.Buyer.Entity.Buyer;
import com.develhope.spring.Seller.ENTITY.SellerEntity;
import com.develhope.spring.Vehicle.Entity.Vehicle;
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
    @OneToOne
    @JoinColumn(name = "orderId", referencedColumnName = "vehicleId")
    private Vehicle vehicle;
    @OneToOne
    @JoinColumn (name = "orderId", referencedColumnName = "buyer_id")
    private Buyer buyer;
    @OneToOne
    @JoinColumn (name = "orderId", referencedColumnName = "sellerId")
    private SellerEntity sellerEntity;

    public Order(Long orderId, double advance, Boolean isPaid, OrderStatus orderStatus, Vehicle vehicle, Buyer buyer, SellerEntity sellerEntity) {
        this.orderId = orderId;
        this.advance = advance;
        this.isPaid = isPaid;
        this.orderStatus = orderStatus;
        this.vehicle = vehicle;
        this.buyer = buyer;
        this.sellerEntity = sellerEntity;
    }

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public SellerEntity getSellerEntity() {
        return sellerEntity;
    }

    public void setSellerEntity(SellerEntity sellerEntity) {
        this.sellerEntity = sellerEntity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", advance=" + advance +
                ", isPaid=" + isPaid +
                ", orderStatus=" + orderStatus +
                ", vehicle=" + vehicle +
                ", buyer=" + buyer +
                ", sellerEntity=" + sellerEntity +
                '}';
    }
}