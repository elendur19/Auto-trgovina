package hr.fer.ris.autotrgovina.service.definition;

import hr.fer.ris.autotrgovina.entity.Vehicle;

import java.util.List;

public interface VehicleService extends CRUDService<Vehicle, Long> {

    Vehicle getById(Long id);

    List<Vehicle> getWithManufacturer(Long manufacturer);
}
