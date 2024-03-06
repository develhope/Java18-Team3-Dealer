package com.develhope.spring.Vehicle.Controller;

import com.develhope.spring.Vehicle.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
}
