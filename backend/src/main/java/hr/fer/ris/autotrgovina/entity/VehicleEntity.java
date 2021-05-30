package hr.fer.ris.autotrgovina.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "vehicle", schema = "sc_auto_trgovina")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Builder
public class VehicleEntity extends BaseEntity {
    @JoinColumn(name="manufacturer_id", insertable=false, updatable = false)
    @ManyToOne
    private ManufacturerEntity manufacturer;
    @Column(name="manufacturer_id")
    @NotNull
    private Long manufacturerId;
    @Column(name = "model")
    @NotNull
    private String model;
    @Column(name = "description", columnDefinition = "varchar(4096)")
    private String description;
    @Column(name = "millage")
    @NotNull
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
}
