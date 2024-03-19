package com.develhope.spring.Vehicle.Controller;

import com.develhope.spring.Vehicle.Dto.VehicleDTO;
import com.develhope.spring.Vehicle.Dto.VehicleStatusDTO;
import com.develhope.spring.Vehicle.Entity.VehicleType;
import com.develhope.spring.Vehicle.Service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
    @Operation(summary = "Create a vehicle")
    @ApiResponses(value = {@ApiResponse (responseCode = "201",description = "created")})
    @PostMapping("/add")
    public ResponseEntity<VehicleDTO> createVehicle (@RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO saveVehicle = vehicleService.createVehicle(vehicleDTO);
        return new ResponseEntity<>(saveVehicle, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a vehicle by Id")
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById (@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }

    @Operation(summary = "Get all vehicle")
    @GetMapping("/all")
    public ResponseEntity<List<VehicleDTO>> getAllVehicle () {
        return new ResponseEntity<>(vehicleService.getAllVehicle(), HttpStatus.OK);
    }

    @Operation(summary = "Get vehicles by price")
    @GetMapping("/byPrice")
    public ResponseEntity<List<VehicleDTO>> getVehicleByPrice (@RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice) {
        return new ResponseEntity<>(vehicleService.getVehicleByPrice(minPrice, maxPrice), HttpStatus.OK);
    }

    @Operation(summary = "Get vehicles by color")
    @GetMapping("/byColor")
    public ResponseEntity<List<VehicleDTO>> getVehicleByColor (@RequestParam String color) {
        return new ResponseEntity<>(vehicleService.getVehicleByColor(color), HttpStatus.OK);
    }

    @Operation(summary = "Get vehicles by brand")
    @GetMapping("/byBrand")
    public ResponseEntity<List<VehicleDTO>> getVehicleByBrand (@RequestParam String brand) {
        return new ResponseEntity<>(vehicleService.getVehicleByBrand(brand), HttpStatus.OK);
    }

    @Operation(summary = "Get vehicles by model")
    @GetMapping("/byModel")
    public ResponseEntity<List<VehicleDTO>> getVehicleByModel (@RequestParam String model) {
        return new ResponseEntity<>(vehicleService.getVehicleByModel(model), HttpStatus.OK);
    }

    @Operation(summary = "Get vehicles by type")
    @GetMapping("/byType")
    public ResponseEntity<List<VehicleDTO>> getVehicleByType (@RequestParam VehicleType vehicleType) {
        return new ResponseEntity<>(vehicleService.getVehicleByType(vehicleType), HttpStatus.OK);
    }

    @Operation(summary = "update a vehicle")
    @PutMapping("/update/{id}")
    public VehicleDTO updateVehicle (@PathVariable Long id, @RequestBody VehicleDTO updateVehicleDTO) {
        return vehicleService.updateVehicle(id, updateVehicleDTO);
    }

    @Operation(summary = "Change a vehicle status")
    @PutMapping("/status/{id}")
    public VehicleDTO changeStatus (@PathVariable Long id, @RequestBody VehicleStatusDTO vehicleStatusDTO) {
        return vehicleService.chanceStatus(id, vehicleStatusDTO);
    }

    @Operation(summary = "Delete a vehicle by Id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVehicle (@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
