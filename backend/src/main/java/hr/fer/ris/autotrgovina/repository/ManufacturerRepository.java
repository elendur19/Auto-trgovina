package hr.fer.ris.autotrgovina.repository;

import hr.fer.ris.autotrgovina.entity.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity, Long>  {
    ManufacturerEntity findByName(String name);
}
