package hr.fer.ris.autotrgovina.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class VehicleRequest {
    @NotEmpty(message = "Manufacturer must be provided")
    private String manufacturer;
    private String model;
    private String price;
    private String power;
    private String millage;
}
