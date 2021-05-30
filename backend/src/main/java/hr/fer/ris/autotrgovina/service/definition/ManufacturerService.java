package hr.fer.ris.autotrgovina.service.definition;

import hr.fer.ris.autotrgovina.entity.ManufacturerEntity;
import hr.fer.ris.autotrgovina.model.ManufacturerModel;

import java.util.List;

public interface ManufacturerService extends CRUDService<ManufacturerEntity, Long> {
    List<ManufacturerModel> getAllManufacturers();
}
