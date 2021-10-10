package hr.fer.ris.autotrgovina.service.definition;

import hr.fer.ris.autotrgovina.entity.Manufacturer;
import hr.fer.ris.autotrgovina.model.ManufacturerModel;

import java.util.List;

public interface ManufacturerService extends CRUDService<Manufacturer, Long> {
    List<ManufacturerModel> getAllManufacturers();
}
