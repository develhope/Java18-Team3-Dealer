package com.develhope.spring.Order.Entity;

import com.develhope.spring.Buyer.Entity.Buyer;
import com.develhope.spring.Seller.ENTITY.SellerEntity;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import jakarta.persistence.*;

@Entity
@Table
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
    private Buyer buyer;
    @ManyToOne
    private SellerEntity sellerEntity;
    @OneToOne
    private Vehicle vehicle;

    public Orders(Long orderId, Double advance, Boolean isPaid, OrderStatus orderStatus, Buyer buyer, SellerEntity sellerEntity, Vehicle vehicle) {
        this.orderId = orderId;
        this.advance = advance;
        this.isPaid = isPaid;
        this.orderStatus = orderStatus;
        this.buyer = buyer;
        this.sellerEntity = sellerEntity;
        this.vehicle = vehicle;
    }

    public Orders() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getAdvance() {
        return advance;
    }

    public void setAdvance(Double advance) {
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", advance=" + advance +
                ", isPaid=" + isPaid +
                ", orderStatus=" + orderStatus +
                ", buyer=" + buyer +
                ", sellerEntity=" + sellerEntity +
                ", vehicle=" + vehicle +
                '}';
    }
}