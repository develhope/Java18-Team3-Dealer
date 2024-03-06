package com.develhope.spring.Rental.Entity;

import com.develhope.spring.Vehicle.Entity.Vehicle;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Table
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;
    @Column
    private double dailyCost;
    @Column
    private double totalCost;
    @Column(nullable = false)
    private boolean paidFlag;
    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(double dailyCost) {
        this.dailyCost = dailyCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isPaidFlag() {
        return paidFlag;
    }

    public void setPaidFlag(boolean paidFlag) {
        this.paidFlag = paidFlag;
    }


    public RentalStatus getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(RentalStatus rentalStatus) {
        this.rentalStatus = rentalStatus;
    }



    public Rental(Long id, LocalDate startDate, LocalDate endDate, double dailyCost, double totalCost, boolean paidFlag, RentalStatus rentalStatus) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dailyCost = dailyCost;
        this.totalCost = totalCost;
        this.paidFlag = paidFlag;
        this.rentalStatus = rentalStatus;

    }

    public Rental() {
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", dailyCost=" + dailyCost +
                ", totalCost=" + totalCost +
                ", paidFlag=" + paidFlag +
                ", rentalStatus=" + rentalStatus +
                '}';
    }
}

