package com.develhope.spring.Purchase.dto;

import com.develhope.spring.Buyer.Entity.Buyer;
import com.develhope.spring.Purchase.Entity.PurchaseStatus;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import jakarta.persistence.*;

public class PurchaseDTO {
    private Long purchaseId;
    private double advance;
    private Boolean isPaid;
    private PurchaseStatus purchaseStatus;
    private Vehicle vehicle;
    private Buyer buyer;
    public PurchaseDTO(Long purchaseId, double advance, Boolean isPaid, PurchaseStatus purchaseStatus, Vehicle vehicle, Buyer buyer) {
        this.purchaseId = purchaseId;
        this.advance = advance;
        this.isPaid = isPaid;
        this.purchaseStatus = purchaseStatus;
        this.vehicle = vehicle;
        this.buyer = buyer;
    }

    public PurchaseDTO() {
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

    public PurchaseStatus getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
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

    @Override
    public String toString() {
        return "PurchaseDTO{" +
                "purchaseId=" + purchaseId +
                ", advance=" + advance +
                ", isPaid=" + isPaid +
                ", purchaseStatus=" + purchaseStatus +
                ", vehicle=" + vehicle +
                ", buyer=" + buyer +
                '}';
    }
}
