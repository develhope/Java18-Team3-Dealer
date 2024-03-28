package com.develhope.spring.Vehicle.Service;

import com.develhope.spring.Exception.AccessDeniedException;
import com.develhope.spring.User.Entity.Role;
import com.develhope.spring.User.Entity.Users;
import com.develhope.spring.Vehicle.Dto.VehicleDTO;
import com.develhope.spring.Vehicle.Dto.VehicleStatusDTO;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import com.develhope.spring.Vehicle.Entity.VehicleStatus;
import com.develhope.spring.Vehicle.Entity.VehicleType;
import com.develhope.spring.Vehicle.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public VehicleDTO createVehicle(Users users, VehicleDTO vehicleDTO) {
        if (users.getRole() == Role.ADMIN) {
            Vehicle vehicle = convertToEntity(vehicleDTO);
            vehicleRepository.save(vehicle);
        } else {
            throw new AccessDeniedException("Only admin can");
        }
        return vehicleDTO;
    }

    public VehicleDTO getVehicleById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle with this id not found: " + vehicleId);
        }
        return convertToDTO(vehicle);
    }

    public List<VehicleDTO> getAllVehicle() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        if (vehicleList.isEmpty()) {
            throw new IllegalArgumentException("No vehicle found");
        } else {
            for (Vehicle vehicle : vehicleList) {
                vehicleDTOList.add(convertToDTO(vehicle));
            }
        }
        return vehicleDTOList;
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

    public List<VehicleDTO> getVehicleByType(VehicleType vehicleType) {
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        if (vehicleType == VehicleType.CAR
                || vehicleType == VehicleType.MOTORBIKE
                || vehicleType == VehicleType.SCOOTER
                || vehicleType == VehicleType.VAN) {
            List<Vehicle> vehicleList = vehicleRepository.getAllVehicleByType(vehicleType.toString());
            for (Vehicle vehicle : vehicleList) {
                vehicleDTOList.add(convertToDTO(vehicle));
            }
        } else {
            throw new IllegalArgumentException("Type not valid: " + vehicleType);
        }
        return vehicleDTOList;
    }

    public VehicleDTO updateVehicle(Long vehicleId, VehicleDTO updateVehicleDTO) {
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
        vehicle.setRegistrationYear(updateVehicle.getRegistrationYear());
        vehicle.setFullType(updateVehicle.getFullType());
        vehicle.setPrice(updateVehicle.getPrice());
        vehicle.setDiscount(updateVehicle.getDiscount());
        vehicle.setAccessories(updateVehicle.getAccessories());
        vehicle.setIsNew(updateVehicle.getIsNew());
        vehicle.setVehicleStatus(updateVehicle.getVehicleStatus());
        vehicle.setVehicleType(updateVehicle.getVehicleType());
        vehicleRepository.save(vehicle);
        return updateVehicleDTO;
    }

    public VehicleDTO chanceStatus(Long vehicleId, VehicleStatusDTO vehicleStatusDTO) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle with this id not found: " + vehicleId);
        }
        if (vehicleStatusDTO.getVehicleStatus() == VehicleStatus.ORDERABLE
                || vehicleStatusDTO.getVehicleStatus() == VehicleStatus.PURCHASABLE
                || vehicleStatusDTO.getVehicleStatus() == VehicleStatus.NOT_AVAILABLE) {
            vehicle.setVehicleStatus(vehicleStatusDTO.getVehicleStatus());
            vehicleRepository.save(vehicle);
            return convertToDTO(vehicle);
        } else {
            throw new IllegalArgumentException("Status not valid: " + vehicleStatusDTO.getVehicleStatus());
        }
    }

    public void deleteVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle with this id not found: " + vehicleId);
        } else {
            vehicleRepository.deleteById(vehicleId);
        }
    }

    private Vehicle convertToEntity(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setDisplacement(vehicleDTO.getDisplacement());
        vehicle.setColor(vehicleDTO.getColor());
        vehicle.setPower(vehicleDTO.getPower());
        vehicle.setTransmission(vehicleDTO.getTransmission());
        vehicle.setRegistrationYear(vehicleDTO.getRegistrationYear());
        vehicle.setFullType(vehicleDTO.getFullType());
        vehicle.setPrice(vehicleDTO.getPrice());
        vehicle.setDiscount(vehicleDTO.getDiscount());
        vehicle.setAccessories(vehicleDTO.getAccessories());
        vehicle.setIsNew(vehicleDTO.getIsNew());
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
        vehicleDTO.setRegistrationYear(vehicle.getRegistrationYear());
        vehicleDTO.setFullType(vehicle.getFullType());
        vehicleDTO.setPrice(vehicle.getPrice());
        vehicleDTO.setDiscount(vehicle.getDiscount());
        vehicleDTO.setAccessories(vehicle.getAccessories());
        vehicleDTO.setIsNew(vehicle.getIsNew());
        vehicleDTO.setVehicleStatus(vehicle.getVehicleStatus());
        vehicleDTO.setVehicleType(vehicle.getVehicleType());
        return vehicleDTO;
    }
}
