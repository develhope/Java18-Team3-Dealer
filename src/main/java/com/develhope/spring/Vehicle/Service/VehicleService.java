package com.develhope.spring.Vehicle.Service;

import com.develhope.spring.Vehicle.Entity.Vehicle;
import com.develhope.spring.Vehicle.Entity.VehicleStatus;
import com.develhope.spring.Vehicle.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleById (Long vehicleId) {
        return vehicleRepository.findById(vehicleId).orElse(null);
    }

    public Vehicle updateVehicle(Long vehicleId, Vehicle updateVehicle) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle == null) return null;
        vehicle.setBrand(updateVehicle.getBrand());
        vehicle.setModel(updateVehicle.getModel());
        vehicle.setDisplacement(updateVehicle.getDisplacement());
        vehicle.setColor(updateVehicle.getColor());
        vehicle.setPower(updateVehicle.getPower());
        vehicle.setTransmission(updateVehicle.getTransmission());
        vehicle.setRegistationYear(updateVehicle.getRegistationYear());
        vehicle.setFullType(updateVehicle.getFullType());
        vehicle.setPrice(updateVehicle.getPrice());
        vehicle.setDiscount(updateVehicle.getDiscount());
        vehicle.setAccessories(updateVehicle.getAccessories());
        vehicle.setNew(updateVehicle.getNew());
        vehicle.setVehicleStatus(updateVehicle.getVehicleStatus());
        vehicle.setVehicleType(updateVehicle.getVehicleType());
        return vehicleRepository.save(vehicle);
    }

    public Vehicle chanceStatus (Long vehicleId, VehicleStatus vehicleStatus) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle == null) return null;
        vehicle.setVehicleStatus(vehicleStatus);
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicleById (Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }
}
