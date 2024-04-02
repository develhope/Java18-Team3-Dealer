package com.develhope.spring.Vehicle.Controller;

import com.develhope.spring.Exception.CustomExceptions;
import com.develhope.spring.User.Entity.Users;
import com.develhope.spring.Vehicle.Dto.VehicleDTO;
import com.develhope.spring.Vehicle.Dto.VehicleStatusDTO;
import com.develhope.spring.Vehicle.Entity.VehicleStatus;
import com.develhope.spring.Vehicle.Entity.VehicleType;
import com.develhope.spring.Vehicle.Service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @Operation(summary = "Create a vehicle")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "created"),
            @ApiResponse(responseCode = "403", description = "Forbidden")})
    @PostMapping("/add")
    public ResponseEntity<?> createVehicle(@AuthenticationPrincipal Users user, @RequestBody VehicleDTO vehicleDTO) {
        try {
            vehicleService.createVehicle(user, vehicleDTO);
            return new ResponseEntity<>(vehicleDTO, HttpStatus.CREATED);
        } catch (CustomExceptions.AccessDeniedException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @Operation(summary = "Get a vehicle by Id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable Long id, @AuthenticationPrincipal Users user) {
        try {
            VehicleDTO vehicleDTO = vehicleService.getVehicleById(id, user);
            return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
        } catch (CustomExceptions.InvalidIdException | CustomExceptions.AccessDeniedException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }


    @Operation(summary = "Get all vehicle")
    @GetMapping("/all")
    public ResponseEntity<?> getAllVehicle() {
        try {
            List<VehicleDTO> vehicleDTOList = vehicleService.getAllVehicle();

            return new ResponseEntity<>(vehicleDTOList, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }

    }

    @Operation(summary = "Get vehicles by price")
    @GetMapping("/byPrice")
    public ResponseEntity<?> getVehicleByPrice(@AuthenticationPrincipal Users user, @RequestParam(defaultValue = "0") BigDecimal minPrice, @RequestParam(defaultValue = "1000000000000") BigDecimal maxPrice) {
        try {
            List<VehicleDTO> vehicleDTOList = vehicleService.getVehicleByPrice(user, minPrice, maxPrice);
            return new ResponseEntity<>(vehicleDTOList, HttpStatus.OK);
        } catch (CustomExceptions.AccessDeniedException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }

    }

    @Operation(summary = "Get vehicles by color")
    @GetMapping("/byColor")
    public ResponseEntity<?> getVehicleByColor(@AuthenticationPrincipal Users user, @RequestParam String color) {
        try {
            List<VehicleDTO> vehicleDTOList = vehicleService.getVehicleByColor(user, color);
            return new ResponseEntity<>(vehicleDTOList, HttpStatus.OK);
        } catch (IllegalArgumentException | CustomExceptions.AccessDeniedException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }

    }

    @Operation(summary = "Get vehicles by brand")
    @GetMapping("/byBrand")
    public ResponseEntity<?> getVehicleByBrand(@AuthenticationPrincipal Users user, @RequestParam String brand) {
        try {
            List<VehicleDTO> vehicleDTOList = vehicleService.getVehicleByBrand(user, brand);
            return new ResponseEntity<>(vehicleDTOList, HttpStatus.OK);
        } catch (IllegalArgumentException | CustomExceptions.AccessDeniedException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @Operation(summary = "Get vehicles by model")
    @GetMapping("/byModel")
    public ResponseEntity<?> getVehicleByModel(@AuthenticationPrincipal Users user, @RequestParam String model) {
        try {
            List<VehicleDTO> vehicleDTOList = vehicleService.getVehicleByModel(user, model);
            return new ResponseEntity<>(vehicleDTOList, HttpStatus.OK);
        } catch (IllegalArgumentException | CustomExceptions.AccessDeniedException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @Operation(summary = "Get vehicles by type")
    @GetMapping("/byType")
    public ResponseEntity<?> getVehicleByType(@AuthenticationPrincipal Users user, @RequestParam VehicleType vehicleType) {
        try {
            List<VehicleDTO> vehicleDTOList = vehicleService.getVehicleByType(user, vehicleType);
            return new ResponseEntity<>(vehicleDTOList, HttpStatus.OK);
        } catch (CustomExceptions.InvalidTypeException | CustomExceptions.AccessDeniedException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @Operation(summary = "Get vehicles by status")
    @GetMapping("/byStatus")
    public ResponseEntity<?> getVehicleByStatus(@AuthenticationPrincipal Users user, @RequestParam VehicleStatus vehicleStatus) {
        try {
            List<VehicleDTO> vehicleDTOList = vehicleService.getVehicleByStatus(user, vehicleStatus);
            return new ResponseEntity<>(vehicleDTOList, HttpStatus.OK);
        } catch (CustomExceptions.InvalidStatusException | CustomExceptions.AccessDeniedException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @Operation(summary = "Get vehicles new")
    @GetMapping("/isNew")
    public ResponseEntity<?> getVehicleNew(@AuthenticationPrincipal Users user, @RequestParam Boolean isNew) {
        try {
            List<VehicleDTO> vehicleDTOList = vehicleService.getVehicleNew(user, isNew);
            return new ResponseEntity<>(vehicleDTOList, HttpStatus.OK);
        } catch (CustomExceptions.AccessDeniedException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @Operation(summary = "update a vehicle")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateVehicle(@PathVariable Long id, @AuthenticationPrincipal Users user, @RequestBody VehicleDTO updateVehicleDTO) {
        try {
            vehicleService.updateVehicle(id, user, updateVehicleDTO);
            return new ResponseEntity<>(updateVehicleDTO, HttpStatus.OK);
        } catch (CustomExceptions.AccessDeniedException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @Operation(summary = "Change a vehicle status")
    @PutMapping("/status/{id}")
    public ResponseEntity<?> changeStatus(@PathVariable Long id, @AuthenticationPrincipal Users user, @RequestBody VehicleStatusDTO vehicleStatusDTO) {
        try {
            VehicleDTO vehicleDTO = vehicleService.chanceStatus(id, user, vehicleStatusDTO);
            return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
        } catch (CustomExceptions.InvalidIdException | CustomExceptions.InvalidStatusException |
                 CustomExceptions.AccessDeniedException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }

    }

    @Operation(summary = "Delete a vehicle by Id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id, @AuthenticationPrincipal Users user) {
        try {
            vehicleService.deleteVehicle(id, user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CustomExceptions.InvalidIdException | CustomExceptions.AccessDeniedException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }
}
