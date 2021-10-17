package hr.fer.ris.autotrgovina.service.definition;

import hr.fer.ris.autotrgovina.entity.VehicleEntity;
import hr.fer.ris.autotrgovina.model.VehicleRequest;
import hr.fer.ris.autotrgovina.model.VehicleResponse;

import java.util.List;

public interface VehicleService extends CRUDService<VehicleEntity, Long> {

    VehicleEntity getById(Long id);

    List<VehicleEntity> getWithManufacturer(Long manufacturer);

    VehicleResponse createNewVehicle(VehicleRequest request);
}
