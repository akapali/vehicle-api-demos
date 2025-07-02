package com.example.vehicleService.controller;

import com.example.vehicleService.entity.Vehicle;
import com.example.vehicleService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Create new vehicle
    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    // Get all vehicles
    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // Get one vehicle by ID
    @GetMapping("/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    // Delete vehicle by ID
    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return "Vehicle deleted with ID: " + id;
    }
}
