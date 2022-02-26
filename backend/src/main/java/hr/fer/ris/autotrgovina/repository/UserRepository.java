package hr.fer.ris.autotrgovina.repository;

import hr.fer.ris.autotrgovina.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
