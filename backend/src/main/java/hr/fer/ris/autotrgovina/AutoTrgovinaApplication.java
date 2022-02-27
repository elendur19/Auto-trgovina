package hr.fer.ris.autotrgovina;

import hr.fer.ris.autotrgovina.entity.Role;
import hr.fer.ris.autotrgovina.entity.User;
import hr.fer.ris.autotrgovina.service.definition.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootApplication()
public class AutoTrgovinaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoTrgovinaApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

/*    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role("USER"));
            userService.saveRole(new Role("MANAGER"));
            userService.saveRole(new Role("ADMIN"));

            userService.saveUser(new User("John", "Frost", "jfrost12", "test1234", 28, new HashSet<>()));
            userService.saveUser(new User("Max", "Berg", "maxberg", "test1234", 58, new HashSet<>()));
            userService.saveUser(new User("Ivan", "Kolki", "kolkiivan", "test1234", 38, new HashSet<>()));

            userService.addRoleToUser("jfrost12", "USER");
            userService.addRoleToUser("jfrost12", "MANAGER");
            userService.addRoleToUser("maxberg", "MANAGER");
            userService.addRoleToUser("kolkiivan", "ADMIN");
        };
    }*/

}