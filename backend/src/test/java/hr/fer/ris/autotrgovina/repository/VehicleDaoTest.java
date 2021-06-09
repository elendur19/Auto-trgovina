package hr.fer.ris.autotrgovina.repository;

import hr.fer.ris.autotrgovina.AutoTrgovinaApplication;
import hr.fer.ris.autotrgovina.entity.ManufacturerEntity;
import hr.fer.ris.autotrgovina.entity.VehicleEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {AutoTrgovinaApplication.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@EnableJpaRepositories({"hr.fer.ris.autotrgovina.repository"})
public class VehicleDaoTest {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Test
    public void notValidVehicleTest() {
        //ManufacturerEntity manufacturerEntity = manufacturerRepository.getById(1L);
        VehicleEntity validVehicle = new VehicleEntity(null, null, "Audi A5", "good car",
                64321, "Osijek", "5443", "first", LocalDate.now(), 4544, 747434);

        Assertions.assertThrows(ConstraintViolationException.class,
                ()-> vehicleRepository.save(validVehicle), "ManufacturerId must have value");

    }

    @Test
    public void validVehicleTest() {
        ManufacturerEntity manufacturerEntity = manufacturerRepository.findByName("Audi");
        VehicleEntity validVehicle = new VehicleEntity(manufacturerEntity, manufacturerEntity.getId(), "Audi A5", "good car",
                64321, "Osijek", "5443", "first", LocalDate.now(), 4544, 747434);

        Assertions.assertDoesNotThrow(()-> vehicleRepository.save(validVehicle),
                "The manufacturer, millage, model, power are not null, the object is valid");

    }

}
