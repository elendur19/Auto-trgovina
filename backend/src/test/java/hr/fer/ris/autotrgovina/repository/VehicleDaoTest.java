package hr.fer.ris.autotrgovina.repository;

import hr.fer.ris.autotrgovina.AutoTrgovinaApplication;
import hr.fer.ris.autotrgovina.entity.Manufacturer;
import hr.fer.ris.autotrgovina.entity.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        //Manufacturer Manufacturer = manufacturerRepository.getById(1L);
        Vehicle notValidVehicle = new Vehicle(null, null, "Audi A5", "good car",
                64321, "Osijek", "5443", "first", LocalDate.now(), 4544, 747434);

        Assertions.assertThrows(ConstraintViolationException.class,
                ()-> vehicleRepository.save(notValidVehicle), "ManufacturerId must have value");
    }

    @Test
    public void validVehicleTest() {
        Manufacturer Manufacturer = manufacturerRepository.findByName("Audi");
        Vehicle validVehicle = new Vehicle(Manufacturer, Manufacturer.getId(), "Audi A5", "good car",
                64321, "Osijek", "5443", "first", LocalDate.now(), 4544, 747434);

        Assertions.assertDoesNotThrow(()-> vehicleRepository.save(validVehicle),
                "The manufacturer, millage, model, power are not null, the object is valid");

    }

}
