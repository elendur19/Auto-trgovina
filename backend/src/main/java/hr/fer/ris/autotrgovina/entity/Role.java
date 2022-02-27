package hr.fer.ris.autotrgovina.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "role", schema = "sc_auto_trgovina")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Role extends BaseEntity {
    private String name;
}
