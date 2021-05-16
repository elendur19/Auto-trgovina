package hr.fer.ris.autotrgovina.controller;

import hr.fer.ris.autotrgovina.entity.VehicleEntity;
import hr.fer.ris.autotrgovina.service.definition.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicle")
@CrossOrigin(origins = {"http://localhost:4200"})
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<VehicleEntity>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleEntity> getVehicleById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(vehicleService.getById(id));
    }

    @PostMapping
    public ResponseEntity<VehicleEntity> createVehicle(@RequestBody VehicleEntity vehicle) {
        return ResponseEntity.ok(vehicleService.save(vehicle));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleEntity> updateVehicle(@PathVariable("id") Long id, @RequestBody VehicleEntity vehicle) {
        vehicle.setId(id);
        return ResponseEntity.ok(vehicleService.update(vehicle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVehicle(@PathVariable("id") Long id) {
        vehicleService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
