package hr.fer.ris.autotrgovina.service.implementation;

import hr.fer.ris.autotrgovina.entity.VehicleEntity;
import hr.fer.ris.autotrgovina.exception.VehicleNotFoundException;
import hr.fer.ris.autotrgovina.repository.VehicleRepository;
import hr.fer.ris.autotrgovina.service.definition.VehicleService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl extends AbstractService<VehicleEntity, Long> implements VehicleService {
    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        super(vehicleRepository);
    }

    @SneakyThrows
    public VehicleEntity getById(Long id) {
        return super.getOptionalById(id).orElseThrow(VehicleNotFoundException::new);
    }
}
