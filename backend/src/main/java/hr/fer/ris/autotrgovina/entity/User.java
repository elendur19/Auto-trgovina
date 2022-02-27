package hr.fer.ris.autotrgovina.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "sc_auto_trgovina")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "age")
    private Integer age;
    @ManyToMany(fetch = FetchType.EAGER)
    //@JoinTable(name = "user_role"
            //joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            //inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    //)
    private Set<Role> roles = new HashSet<>();
}
