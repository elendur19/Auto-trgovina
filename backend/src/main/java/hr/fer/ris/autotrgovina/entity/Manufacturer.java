package hr.fer.ris.autotrgovina.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "manufacturer", schema = "sc_auto_trgovina")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer extends BaseEntity {
    @Column(name = "name", unique = true)
    @NotNull
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="manufacturer")
    private List<Vehicle> vehicles;
}
