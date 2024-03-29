package hr.fer.ris.autotrgovina.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "vehicle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Builder
public class Vehicle extends BaseEntity {
    @JoinColumn(name = "manufacturer_id", insertable = false, updatable = false)
    @ManyToOne
    //@JsonIgnore
    private Manufacturer manufacturer;
    @Column(name = "manufacturer_id")
    @NotNull
    private Long manufacturerId;
    @Column(name = "model")
    @NotNull
    private String model;
    @Column(name = "description", columnDefinition = "varchar(4096)")
    private String description;
    @Column(name = "millage")
    private Integer millage;
    @Column(name = "location")
    private String location;
    @Column(name = "contact")
    private String contact;
    @Column(name = "variant")
    private String variant;
    @Column(name = "first_registration")
    private LocalDate firstRegistration;
    @Column(name = "power")
    @NotNull
    private Integer power;
    @Column(name = "price")
    @NotNull
    private Integer price;

    public Vehicle(Manufacturer manufacturer, String model, String description) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.description = description;
    }
}
