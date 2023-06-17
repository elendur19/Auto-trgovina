package hr.fer.ris.autotrgovina.service.implementation;

import hr.fer.ris.autotrgovina.entity.Manufacturer;
import hr.fer.ris.autotrgovina.exception.ManufacturerExistsException;
import hr.fer.ris.autotrgovina.model.ManufacturerModel;
import hr.fer.ris.autotrgovina.model.ManufacturerRequest;
import hr.fer.ris.autotrgovina.service.definition.ManufacturerService;
import hr.fer.ris.autotrgovina.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManufacturerServiceImpl extends AbstractService<Manufacturer, Long> implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        super(manufacturerRepository);
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<ManufacturerModel> getAllManufacturers() {
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        List<ManufacturerModel> manufacturerModels = new ArrayList<>();
        for (Manufacturer manufacturer : manufacturers) {
            manufacturerModels.add(mapManufacturerToModel(manufacturer));

        }
        return manufacturerModels;
    }

    private ManufacturerModel mapManufacturerToModel(Manufacturer manufacturer) {
        ManufacturerModel manufacturerModel = new ManufacturerModel();
        manufacturerModel.setName(manufacturer.getName());
        manufacturerModel.setId(manufacturer.getId());
        return manufacturerModel;
    }

    @Override
    public ManufacturerModel createNewManufacturer(ManufacturerRequest request) {
        String requestedName = request.getManufacturerName();
        if (manufacturerRepository.existsByName(requestedName))
            throw new ManufacturerExistsException(requestedName);
        var manufacturer = new Manufacturer();
        manufacturer.setName(requestedName);
        manufacturerRepository.save(manufacturer);
        return mapManufacturerToModel(manufacturer);
    }
}
