package hr.fer.ris.autotrgovina.repository;

import hr.fer.ris.autotrgovina.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
