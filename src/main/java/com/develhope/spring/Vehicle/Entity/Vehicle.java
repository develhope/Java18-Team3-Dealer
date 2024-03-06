package com.develhope.spring.Vehicle.Entity;

import com.develhope.spring.Rental.Entity.Rental;
import jakarta.persistence.*;
import java.time.Year;
import java.util.List;
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
    private Year registationYear;
    @Column(nullable = false)
    private String fullType;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Double discount;
    @Column(nullable = false)
    private List<String> accessories;
    @Column(nullable = false)
    private Boolean isNew;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleStatus vehicleStatus;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    //@OneToMany(fetch = FetchType.LAZY,mappedBy = "vehicle")
    //private List<Rental> rental;
    //@ManyToOne
    //private User admin;

    public Vehicle(Long vehicleId, String brand, String model, int displacement, String color, int power, String transmission, Year registationYear, String fullType, Double price, Double discount, List<String> accessories, Boolean isNew, VehicleStatus vehicleStatus, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.displacement = displacement;
        this.color = color;
        this.power = power;
        this.transmission = transmission;
        this.registationYear = registationYear;
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

    public Long getVehicleIdId() {
        return vehicleId;
    }

    public void setVehicleIdId(Long id) {
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

    public Year getRegistationYear() {
        return registationYear;
    }

    public void setRegistationYear(Year registationYear) {
        this.registationYear = registationYear;
    }

    public String getFullType() {
        return fullType;
    }

    public void setFullType(String fullType) {
        this.fullType = fullType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public List<String> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<String> accessories) {
        this.accessories = accessories;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
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
                ", registationYear=" + registationYear +
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
