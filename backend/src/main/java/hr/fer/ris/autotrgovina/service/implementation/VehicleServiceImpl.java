package hr.fer.ris.autotrgovina.service.implementation;

import hr.fer.ris.autotrgovina.entity.Vehicle;
import hr.fer.ris.autotrgovina.exception.VehicleNotFoundException;
import hr.fer.ris.autotrgovina.repository.VehicleRepository;
import hr.fer.ris.autotrgovina.service.definition.VehicleService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl extends AbstractService<Vehicle, Long> implements VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        super(vehicleRepository);
        this.vehicleRepository = vehicleRepository;
    }

    @SneakyThrows
    public Vehicle getById(Long id) {
        return super.getOptionalById(id).orElseThrow(VehicleNotFoundException::new);
    }

    @Override
    public List<Vehicle> getWithManufacturer(Long manufacturer) {
        return vehicleRepository.findByManufacturerId(manufacturer);
    }
}
