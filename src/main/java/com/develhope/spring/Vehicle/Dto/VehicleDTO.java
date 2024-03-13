package com.develhope.spring.Vehicle.Dto;

import com.develhope.spring.Vehicle.Entity.VehicleStatus;
import com.develhope.spring.Vehicle.Entity.VehicleType;

import java.time.Year;
import java.util.List;

public class VehicleDTO {
    private String brand;
    private String model;
    private int displacement;
    private String color;
    private int power;
    private String transmission;
    private Year registrationYear;
    private String fullType;
    private Double price;
    private Double discount;
    private List<String> accessories;
    private Boolean isNew;
    private VehicleStatus vehicleStatus;
    private VehicleType vehicleType;

    public VehicleDTO() {
    }

    public VehicleDTO(String brand, String model, int displacement, String color, int power, String transmission, int registrationYear, String fullType, Double price, Double discount, List<String> accessories, Boolean isNew, VehicleStatus vehicleStatus, VehicleType vehicleType) {
        this.brand = brand;
        this.model = model;
        this.displacement = displacement;
        this.color = color;
        this.power = power;
        this.transmission = transmission;
        this.registrationYear = Year.of(registrationYear);
        this.fullType = fullType;
        this.price = price;
        this.discount = discount;
        this.accessories = accessories;
        this.isNew = isNew;
        this.vehicleStatus = vehicleStatus;
        this.vehicleType = vehicleType;
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
        return registrationYear;
    }

    public void setRegistationYear(int registationYear) {
        this.registrationYear = Year.of(registationYear);
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
        return "VehicleDTO{" +
                "brand='" + brand + '\'' +
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
