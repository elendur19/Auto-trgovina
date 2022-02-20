package hr.fer.ris.autotrgovina.controller;

import hr.fer.ris.autotrgovina.entity.Manufacturer;
import hr.fer.ris.autotrgovina.model.ManufacturerModel;
import hr.fer.ris.autotrgovina.model.ManufacturerRequest;
import hr.fer.ris.autotrgovina.service.definition.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/manufacturer")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<ManufacturerModel>> getAllManufacturers() {
        return ResponseEntity.ok(manufacturerService.getAllManufacturers());
    }

    @PostMapping
    //@PreAuthorize("hasAuthority('manufacturer:write')")
    public ResponseEntity<ManufacturerModel> createManufacturer(@RequestBody ManufacturerRequest request) {
        return ResponseEntity.ok(manufacturerService.createNewManufacturer(request));
    }
}
