package hr.fer.ris.autotrgovina.repository;

import hr.fer.ris.autotrgovina.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long>  {
    Manufacturer findByName(String name);
}
