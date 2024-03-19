package com.develhope.spring.Purchase.Entity;

import com.develhope.spring.Buyer.Entity.Buyer;
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
    private PurchaseStatus purchaseStatus;
    @OneToOne
    @JoinColumn(name = "purchaseId", referencedColumnName = "vehicleId")
    private Vehicle vehicle;
    @OneToOne
    @JoinColumn(name = "purchaseId", referencedColumnName = "buyer_id")
    private Buyer buyer;

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

    public Purchase(Long purchaseId, double advance, Boolean isPaid, PurchaseStatus purchaseStatus, Vehicle vehicle, Buyer buyer) {
        this.purchaseId = purchaseId;
        this.advance = advance;
        this.isPaid = isPaid;
        this.purchaseStatus = purchaseStatus;
        this.vehicle = vehicle;
        this.buyer = buyer;
    }

    public Purchase() {
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", advance=" + advance +
                ", isPaid=" + isPaid +
                ", purchaseStatus=" + purchaseStatus +
                ", vehicle=" + vehicle +
                ", buyer=" + buyer +
                '}';
    }
}

