package com.develhope.spring.Rental.Entity;

import com.develhope.spring.User.Entity.Users;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Table
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;
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
    @ManyToOne
    private Users users;
    @ManyToOne
    private Vehicle vehicle;

    public Rental(Long rentalId, LocalDate startDate, LocalDate endDate, double dailyCost, double totalCost, boolean paidFlag, RentalStatus rentalStatus, Users users, Vehicle vehicle) {
        this.rentalId = rentalId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dailyCost = dailyCost;
        this.totalCost = totalCost;
        this.paidFlag = paidFlag;
        this.rentalStatus = rentalStatus;
        this.users = users;
        this.vehicle = vehicle;
    }

    public Rental() {
    }

    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", dailyCost=" + dailyCost +
                ", totalCost=" + totalCost +
                ", paidFlag=" + paidFlag +
                ", rentalStatus=" + rentalStatus +
                ", users=" + users +
                ", vehicle=" + vehicle +
                '}';
    }
}

