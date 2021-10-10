package hr.fer.ris.autotrgovina.repository;

import hr.fer.ris.autotrgovina.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByManufacturerId(Long manufacturer);
}
