package hr.fer.ris.autotrgovina.service.implementation;

import hr.fer.ris.autotrgovina.entity.ManufacturerEntity;
import hr.fer.ris.autotrgovina.entity.VehicleEntity;
import hr.fer.ris.autotrgovina.exception.ManufacturerNotFoundException;
import hr.fer.ris.autotrgovina.exception.VehicleNotFoundException;
import hr.fer.ris.autotrgovina.model.VehicleRequest;
import hr.fer.ris.autotrgovina.model.VehicleResponse;
import hr.fer.ris.autotrgovina.repository.ManufacturerRepository;
import hr.fer.ris.autotrgovina.repository.VehicleRepository;
import hr.fer.ris.autotrgovina.service.definition.VehicleService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl extends AbstractService<VehicleEntity, Long> implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, ManufacturerRepository manufacturerRepository) {
        super(vehicleRepository);
        this.vehicleRepository = vehicleRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @SneakyThrows
    public VehicleEntity getById(Long id) {
        return super.getOptionalById(id).orElseThrow(VehicleNotFoundException::new);
    }

    @Override
    public List<VehicleEntity> getWithManufacturer(Long manufacturer) {
        return vehicleRepository.findByManufacturerId(manufacturer);
    }

    @Override
    public VehicleResponse createNewVehicle(VehicleRequest request) {
        ManufacturerEntity manufacturer = manufacturerRepository.findByName(request.getManufacturerName());
        if (manufacturer == null) throw new ManufacturerNotFoundException(request.getManufacturerName());
        VehicleEntity vehicle = new VehicleEntity();
        vehicle.setManufacturer(manufacturer);
        vehicle.setManufacturerId(manufacturer.getId());
        vehicle.setModel(request.getModel());
        vehicle.setPower(request.getPower());
        vehicle.setPrice(request.getPrice());
        vehicleRepository.save(vehicle);
        return mapVehicleEntityToResponse(vehicle);
    }

    private VehicleResponse mapVehicleEntityToResponse(VehicleEntity vehicle) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setModel(vehicle.getModel());
        vehicleResponse.setPower(vehicle.getPower());
        vehicleResponse.setManufacturerName(vehicle.getManufacturer().getName());
        vehicleResponse.setPrice(vehicle.getPrice());
        return vehicleResponse;
    }
}
