package com.develhope.spring.Vehicle.Dto;

import com.develhope.spring.Vehicle.Entity.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleStatusDTO {
    private VehicleStatus vehicleStatus;

    @Override
    public String toString() {
        return "VehicleStatusDTO{" +
                "vehicleStatus=" + vehicleStatus +
                '}';
    }
}

