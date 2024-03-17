package com.develhope.spring.Vehicle.Service;

import com.develhope.spring.Vehicle.Dto.VehicleDTO;
import com.develhope.spring.Vehicle.Dto.VehicleStatusDTO;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import com.develhope.spring.Vehicle.Entity.VehicleStatus;
import com.develhope.spring.Vehicle.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Year;
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

    public VehicleDTO getVehicleById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle with this id not found: " + vehicleId);
        }
        return convertToDTO(vehicle);
    }

    public List<VehicleDTO> getVehicleByPrice(BigDecimal minPrice, BigDecimal maxPrice) { //dare valori default in controller
        if (minPrice.compareTo(maxPrice) > 0) {
            throw new IllegalArgumentException("the lower price cannot be greater than the higher price");
        }
        List<Vehicle> vehicleList = vehicleRepository.getAllVehicleByPrice(minPrice, maxPrice);
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            vehicleDTOList.add(convertToDTO(vehicle));
        }
        return vehicleDTOList;
    }

    public List<VehicleDTO> getVehicleByColor(String color) {
        List<Vehicle> vehicleList = vehicleRepository.getAllVehicleByColor(color);
        if (vehicleList.isEmpty()) {
            throw new IllegalArgumentException("No vehicle found with color: " + color);
        }
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            vehicleDTOList.add(convertToDTO(vehicle));
        }
        return vehicleDTOList;
    }

    public List<VehicleDTO> getVehicleByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.getAllVehicleByBrand(brand);
        if (vehicleList.isEmpty()) {
            throw new IllegalArgumentException("No vehicle found with brand: " + brand);
        }
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            vehicleDTOList.add(convertToDTO(vehicle));
        }
        return vehicleDTOList;
    }

    public List<VehicleDTO> getVehicleByModel(String model) {
        List<Vehicle> vehicleList = vehicleRepository.getAllVehicleByModel(model);
        if (vehicleList.isEmpty()) {
            throw new IllegalArgumentException("No vehicle found with model: " + model);
        }
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            vehicleDTOList.add(convertToDTO(vehicle));
        }
        return vehicleDTOList;
    }

    public Vehicle updateVehicle(Long vehicleId, VehicleDTO updateVehicleDTO) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle with this id not found: " + vehicleId);
        }
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

    public Vehicle chanceStatus(Long vehicleId, VehicleStatusDTO vehicleStatusDTO) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle with this id not found: " + vehicleId);
        }
        if (vehicleStatusDTO.getVehicleStatus() == VehicleStatus.ORDERABLE
                || vehicleStatusDTO.getVehicleStatus() == VehicleStatus.PURCHASABLE
                || vehicleStatusDTO.getVehicleStatus() == VehicleStatus.NOT_AVAILABLE) {
            vehicle.setVehicleStatus(vehicleStatusDTO.getVehicleStatus());
            return vehicleRepository.save(vehicle);
        } else {
            throw new IllegalArgumentException("Status not valid: " + vehicleStatusDTO.getVehicleStatus());
        }
    }

    public void deleteVehicleById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle with this id not found: " + vehicleId);
        }
        vehicleRepository.deleteById(vehicle.getVehicleIdId());
    }

    private Vehicle convertToEntity(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setDisplacement(vehicleDTO.getDisplacement());
        vehicle.setColor(vehicleDTO.getColor());
        vehicle.setPower(vehicleDTO.getPower());
        vehicle.setTransmission(vehicleDTO.getTransmission());
        vehicle.setRegistationYear(Year.of(vehicleDTO.getRegistationYear()));
        vehicle.setFullType(vehicleDTO.getFullType());
        vehicle.setPrice(vehicleDTO.getPrice());
        vehicle.setDiscount(vehicleDTO.getDiscount());
        vehicle.setAccessories(vehicleDTO.getAccessories());
        vehicle.setNew(vehicleDTO.getNew());
        vehicle.setVehicleStatus(vehicleDTO.getVehicleStatus());
        vehicle.setVehicleType(vehicleDTO.getVehicleType());
        return vehicle;
    }

    private VehicleDTO convertToDTO(Vehicle vehicle) {
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
