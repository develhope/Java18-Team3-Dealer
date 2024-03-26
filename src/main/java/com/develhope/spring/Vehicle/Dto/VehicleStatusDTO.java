package com.develhope.spring.Vehicle.Dto;

import com.develhope.spring.Vehicle.Entity.VehicleStatus;

public class VehicleStatusDTO {
    private VehicleStatus vehicleStatus;

    public VehicleStatusDTO(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public VehicleStatusDTO() {
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    @Override
    public String toString() {
        return "VehicleStatusDTO{" +
                "vehicleStatus=" + vehicleStatus +
                '}';
    }
}

