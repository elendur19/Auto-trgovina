package hr.fer.ris.autotrgovina.service.implementation;

import hr.fer.ris.autotrgovina.entity.Manufacturer;
import hr.fer.ris.autotrgovina.entity.Vehicle;
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
public class VehicleServiceImpl extends AbstractService<Vehicle, Long> implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, ManufacturerRepository manufacturerRepository) {
        super(vehicleRepository);
        this.vehicleRepository = vehicleRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @SneakyThrows
    public Vehicle getById(Long id) {
        return super.getOptionalById(id).orElseThrow(VehicleNotFoundException::new);
    }

    @Override
    public List<Vehicle> getWithManufacturer(Long manufacturer) {
        return vehicleRepository.findByManufacturerId(manufacturer);
    }

    @Override
    public VehicleResponse createNewVehicle(VehicleRequest request) {
        Manufacturer manufacturer = manufacturerRepository.findByName(request.getManufacturer());
        if (manufacturer == null) throw new ManufacturerNotFoundException(request.getManufacturer());
        Vehicle vehicle = new Vehicle();
        vehicle.setManufacturer(manufacturer);
        vehicle.setManufacturerId(manufacturer.getId());
        vehicle.setModel(request.getModel());
        vehicle.setPower(request.getPower());
        vehicle.setPrice(request.getPrice());
        vehicleRepository.save(vehicle);
        return mapVehicleToResponse(vehicle);
    }

    private VehicleResponse mapVehicleToResponse(Vehicle vehicle) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setModel(vehicle.getModel());
        vehicleResponse.setPower(vehicle.getPower());
        vehicleResponse.setManufacturerName(vehicle.getManufacturer().getName());
        vehicleResponse.setPrice(vehicle.getPrice());
        return vehicleResponse;
    }
}
