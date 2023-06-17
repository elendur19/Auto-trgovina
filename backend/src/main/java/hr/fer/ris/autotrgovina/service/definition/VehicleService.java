package hr.fer.ris.autotrgovina.service.definition;

import hr.fer.ris.autotrgovina.entity.Vehicle;
import hr.fer.ris.autotrgovina.model.VehicleRequest;
import hr.fer.ris.autotrgovina.model.VehicleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VehicleService extends CRUDService<Vehicle, Long> {

    Vehicle getById(Long id);

    List<Vehicle> getWithManufacturer(Long manufacturer);

    VehicleResponse createNewVehicle(VehicleRequest request);

    List<VehicleResponse> getAllVehicles();

    Page<VehicleResponse> getVehicles(Pageable pageable);
}
