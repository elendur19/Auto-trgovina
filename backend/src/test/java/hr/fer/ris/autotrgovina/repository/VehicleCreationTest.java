package hr.fer.ris.autotrgovina.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.fer.ris.autotrgovina.AutoTrgovinaApplication;
import hr.fer.ris.autotrgovina.entity.Manufacturer;
import hr.fer.ris.autotrgovina.entity.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {AutoTrgovinaApplication.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VehicleCreationTest {

//    @MockBean
//    private VehicleRepository vehicleRepository;

    private final String auth = "Basic " + Base64.getEncoder().encodeToString("admin:admin".getBytes());

//    @MockBean
//    private VehicleServiceImpl vehicleService;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public void createVehicle() {
    }

    @Test
    public void getVehiclesTest() throws Exception {


    }

    @Test
    public void createValidVehicleTest() throws Exception {

        Manufacturer manufacturerEntity = manufacturerRepository.findByName("Audi");
        Vehicle vehicleToSave = new Vehicle(manufacturerEntity, manufacturerEntity.getId(), "Audi A5", "good car",
                64321, "Osijek", "5443", "first", LocalDate.now(), 4544, 747434);

        String vehicleAsString = mapper.writeValueAsString(vehicleToSave);

        // create new vehicle in database
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/api/vehicle")
                        .header("Authorization", auth)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(vehicleAsString);

        MvcResult result = this.mockMvc.perform(builder).andReturn();
        String content = result.getResponse().getContentAsString();
        Vehicle createdVehicle = mapper.readValue(content, Vehicle.class);
        Long savedVehicleId = createdVehicle.getId();
        //Assertions.assertEquals(200, result.getResponse().getStatus());

        //VehicleEntity vehicle = new VehicleEntity(null, "Audi A3", "good car", 12322);
        result = this.mockMvc.perform(get("/api/vehicle").accept("application/json"))
                .andExpect(status().isOk()).andReturn();

        List<Vehicle> vehicles = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
        boolean createdVehiclePresent = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(savedVehicleId)) {
                createdVehiclePresent = true;
                break;
            }
        }

        // ASSERT CREATED VEHICLE IS PRESENT
        Assertions.assertTrue(createdVehiclePresent);
    }
}
