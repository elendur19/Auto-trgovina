package hr.fer.ris.autotrgovina.service.definition;

import hr.fer.ris.autotrgovina.entity.VehicleEntity;

public interface VehicleService extends CRUDService<VehicleEntity, Long> {

    VehicleEntity getById(Long id);
}
