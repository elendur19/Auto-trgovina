package hr.fer.ris.autotrgovina.repository;

import hr.fer.ris.autotrgovina.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

    List<VehicleEntity> findByManufacturerId( Long manufacturer);
}
