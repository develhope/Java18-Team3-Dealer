package com.develhope.spring.Purchase.dto;

import com.develhope.spring.Order.Entity.Orders;
import com.develhope.spring.Purchase.Entity.PurchaseStatus;
import com.develhope.spring.User.Entity.Users;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import jakarta.persistence.*;

public class PurchaseDTO {
    private double advance;
    private Boolean isPaid;
    private PurchaseStatus purchaseStatus;
    private Orders orders;

    public PurchaseDTO(double advance, Boolean isPaid, PurchaseStatus purchaseStatus,Orders orders) {
        this.advance = advance;
        this.isPaid = isPaid;
        this.purchaseStatus = purchaseStatus;
        this.orders = orders;
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

    public PurchaseStatus getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public PurchaseDTO() {
    }

    @Override
    public String toString() {
        return "PurchaseDTO{" +
                ", advance=" + advance +
                ", isPaid=" + isPaid +
                ", purchaseStatus=" + purchaseStatus +
                ", orders=" + orders +
                '}';
    }
}