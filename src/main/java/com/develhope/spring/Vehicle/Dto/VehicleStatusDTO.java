package com.develhope.spring.Vehicle.Dto;

public class VehicleStatusDTO {
    private String status;

    public VehicleStatusDTO(String status) {
        this.status = status;
    }

    public VehicleStatusDTO() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VehicleStatusDTO{" +
                "status='" + status + '\'' +
                '}';
    }
}
