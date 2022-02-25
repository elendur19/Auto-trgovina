package hr.fer.ris.autotrgovina.controller;

import hr.fer.ris.autotrgovina.entity.Vehicle;
import hr.fer.ris.autotrgovina.model.VehicleRequest;
import hr.fer.ris.autotrgovina.model.VehicleResponse;
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
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(vehicleService.getById(id));
    }

    // query by manufacturer
    @GetMapping("/filter")
    public ResponseEntity<List<Vehicle>> getVehiclesWithManufacturer(@RequestParam(name = "manufacturer") Long manufacturer) {
        return ResponseEntity.ok(vehicleService.getWithManufacturer(manufacturer));
    }

    @PostMapping
    public ResponseEntity<VehicleResponse> createVehicle(@RequestBody VehicleRequest request) {
        return ResponseEntity.ok(vehicleService.createNewVehicle(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") Long id, @RequestBody Vehicle vehicle) {
        vehicle.setId(id);
        return ResponseEntity.ok(vehicleService.update(vehicle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable("id") Long id) {
        vehicleService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
