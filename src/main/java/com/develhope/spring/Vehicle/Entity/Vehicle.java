package com.develhope.spring.Vehicle.Entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Year;

@Entity
@Table
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private int displacement;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private int power;
    @Column(nullable = false)
    private String transmission;
    @Column(nullable = false)
    private Year registrationYear;
    @Column(nullable = false)
    private String fullType;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private BigDecimal discount;
    @Column(nullable = false)
    private String accessories;
    @Column(nullable = false)
    private Boolean isNew;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleStatus vehicleStatus;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    public Vehicle(Long vehicleId, String brand, String model, int displacement, String color, int power, String transmission, Year registrationYear, String fullType, BigDecimal price, BigDecimal discount, String accessories, Boolean isNew, VehicleStatus vehicleStatus, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.displacement = displacement;
        this.color = color;
        this.power = power;
        this.transmission = transmission;
        this.registrationYear = registrationYear;
        this.fullType = fullType;
        this.price = price;
        this.discount = discount;
        this.accessories = accessories;
        this.isNew = isNew;
        this.vehicleStatus = vehicleStatus;
        this.vehicleType = vehicleType;
    }

    public Vehicle() {
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long id) {
        this.vehicleId = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Year getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(Year registrationYear) {
        this.registrationYear = registrationYear;
    }

    public String getFullType() {
        return fullType;
    }

    public void setFullType(String fullType) {
        this.fullType = fullType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "id=" + vehicleId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", displacement=" + displacement +
                ", color='" + color + '\'' +
                ", power=" + power +
                ", transmission='" + transmission + '\'' +
                ", registrationYear=" + registrationYear +
                ", fullType='" + fullType + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", accessories=" + accessories +
                ", isNew=" + isNew +
                ", vehicleStatus=" + vehicleStatus +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
