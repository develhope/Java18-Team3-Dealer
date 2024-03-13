package com.develhope.spring.Vehicle.Service;

import com.develhope.spring.Vehicle.Dto.VehicleDTO;
import com.develhope.spring.Vehicle.Dto.VehicleStatusDTO;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import com.develhope.spring.Vehicle.Entity.VehicleStatus;
import com.develhope.spring.Vehicle.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = convertToEntity(vehicleDTO);
        return vehicleRepository.save(vehicle);
    }

    public VehicleDTO getVehicleById (Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle == null) return null;
        return convertToDTO(vehicle);
    }

    public Vehicle updateVehicle(Long vehicleId, VehicleDTO updateVehicleDTO) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle == null) return null;
        Vehicle updateVehicle = convertToEntity(updateVehicleDTO);
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

    public Vehicle chanceStatus (Long vehicleId, VehicleStatusDTO vehicleStatusDTO) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle == null) return null;
        vehicle.setVehicleStatus(VehicleStatus.valueOf(vehicleStatusDTO.getStatus()));
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicleById (Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }

    private Vehicle convertToEntity (VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setDisplacement(vehicleDTO.getDisplacement());
        vehicle.setColor(vehicleDTO.getColor());
        vehicle.setPower(vehicleDTO.getPower());
        vehicle.setTransmission(vehicleDTO.getTransmission());
        vehicle.setRegistationYear(vehicleDTO.getRegistationYear());
        vehicle.setFullType(vehicleDTO.getFullType());
        vehicle.setPrice(vehicleDTO.getPrice());
        vehicle.setDiscount(vehicleDTO.getDiscount());
        vehicle.setAccessories(vehicleDTO.getAccessories());
        vehicle.setNew(vehicleDTO.getNew());
        vehicle.setVehicleStatus(vehicleDTO.getVehicleStatus());
        vehicle.setVehicleType(vehicleDTO.getVehicleType());
        return vehicle;
    }

    public List<VehicleDTO> getVehicleByColor (String color) {
        List<Vehicle> vehicleList = vehicleRepository.getAllVehicleByColor(color);
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            vehicleDTOList.add(convertToDTO(vehicle));
        }
        return vehicleDTOList;
    }

    private VehicleDTO convertToDTO (Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setDisplacement(vehicle.getDisplacement());
        vehicleDTO.setColor(vehicle.getColor());
        vehicleDTO.setPower(vehicle.getPower());
        vehicleDTO.setTransmission(vehicle.getTransmission());
        vehicleDTO.setRegistationYear(vehicle.getRegistationYear().getValue());
        vehicleDTO.setFullType(vehicle.getFullType());
        vehicleDTO.setPrice(vehicle.getPrice());
        vehicleDTO.setDiscount(vehicle.getDiscount());
        vehicleDTO.setAccessories(vehicle.getAccessories());
        vehicleDTO.setNew(vehicle.getNew());
        vehicleDTO.setVehicleStatus(vehicle.getVehicleStatus());
        vehicleDTO.setVehicleType(vehicle.getVehicleType());
        return vehicleDTO;
    }
}
