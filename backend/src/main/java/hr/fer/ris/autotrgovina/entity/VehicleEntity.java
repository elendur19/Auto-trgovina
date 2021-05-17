package hr.fer.ris.autotrgovina.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "model")
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
    private Integer power;
    @Column(name = "price")
    private Integer price;
}
