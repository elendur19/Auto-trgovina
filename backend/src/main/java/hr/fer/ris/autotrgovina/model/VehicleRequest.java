package hr.fer.ris.autotrgovina.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleRequest {
    private String manufacturer;
    private String model;
    private Integer price;
    private Integer power;
}
