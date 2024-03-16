package com.develhope.spring.Purchase.Entity;

import com.develhope.spring.Buyer.Entity.Buyer;
import com.develhope.spring.Order.Entity.Orders;
import com.develhope.spring.Seller.ENTITY.SellerEntity;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import jakarta.persistence.*;

@Entity
@Table
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;
    @Column(nullable = false)
    private double advance;
    @Column(nullable = false)
    private Boolean isPaid;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PurchaseStatus orderStatus;
    @OneToOne
    private Orders orders;

    public Purchase(Long purchaseId, double advance, Boolean isPaid, PurchaseStatus orderStatus, Orders orders) {
        this.purchaseId = purchaseId;
        this.advance = advance;
        this.isPaid = isPaid;
        this.orderStatus = orderStatus;
        this.orders = orders;
    }

    public Purchase() {
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
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

    public PurchaseStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(PurchaseStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", advance=" + advance +
                ", isPaid=" + isPaid +
                ", orderStatus=" + orderStatus +
                ", orders=" + orders +
                '}';
    }
}

