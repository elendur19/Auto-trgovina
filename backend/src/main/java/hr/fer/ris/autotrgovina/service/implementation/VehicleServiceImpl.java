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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public Page<VehicleResponse> getVehicles(Pageable pageable) {
        var vehicles = vehicleRepository.findAll(pageable);
        return vehicles.map(this::mapVehicleToResponse);
    }

    @Override
    public List<VehicleResponse> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(this::mapVehicleToResponse)
                .toList();
    }

    @Override
    @Transactional
    public VehicleResponse createNewVehicle(VehicleRequest request) {
        Manufacturer manufacturer = manufacturerRepository.findByName(request.getManufacturer());
        if (manufacturer == null) throw new ManufacturerNotFoundException(request.getManufacturer());
        var vehicle = new Vehicle();
        vehicle.setManufacturer(manufacturer);
        vehicle.setManufacturerId(manufacturer.getId());
        vehicle.setModel(request.getModel());
        vehicle.setPower(Integer.parseInt(request.getPower()));
        vehicle.setPrice(Integer.parseInt(request.getPrice()));
        vehicle.setMillage(Integer.parseInt(request.getMillage()));
        vehicleRepository.save(vehicle);
        return mapVehicleToResponse(vehicle);
    }

    private VehicleResponse mapVehicleToResponse(Vehicle vehicle) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setId(vehicle.getId());
        vehicleResponse.setModel(vehicle.getModel());
        vehicleResponse.setPower(vehicle.getPower());
        vehicleResponse.setManufacturerName(vehicle.getManufacturer().getName());
        vehicleResponse.setPrice(vehicle.getPrice());
        return vehicleResponse;
    }
}
