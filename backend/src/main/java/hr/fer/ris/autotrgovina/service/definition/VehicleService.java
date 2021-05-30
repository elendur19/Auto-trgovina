package hr.fer.ris.autotrgovina.service.definition;

import hr.fer.ris.autotrgovina.entity.VehicleEntity;

import java.util.List;

public interface VehicleService extends CRUDService<VehicleEntity, Long> {

    VehicleEntity getById(Long id);

    List<VehicleEntity> getWithManufacturer(Long manufacturer);
}
