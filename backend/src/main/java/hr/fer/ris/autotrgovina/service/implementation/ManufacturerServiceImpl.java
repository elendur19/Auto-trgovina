package hr.fer.ris.autotrgovina.service.implementation;

import hr.fer.ris.autotrgovina.entity.ManufacturerEntity;
import hr.fer.ris.autotrgovina.model.ManufacturerModel;
import hr.fer.ris.autotrgovina.service.definition.ManufacturerService;
import hr.fer.ris.autotrgovina.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManufacturerServiceImpl extends AbstractService<ManufacturerEntity, Long> implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        super(manufacturerRepository);
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<ManufacturerModel> getAllManufacturers() {
        List<ManufacturerEntity> manufacturers = manufacturerRepository.findAll();
        List<ManufacturerModel> manufacturerModels = new ArrayList<>();
        for (ManufacturerEntity manufacturerEntity : manufacturers) {
            ManufacturerModel manufacturerModel = new ManufacturerModel();
            manufacturerModel.setName(manufacturerEntity.getName());
            manufacturerModel.setId(manufacturerEntity.getId());
            manufacturerModels.add(manufacturerModel);
        }
        return manufacturerModels;
    }
}
