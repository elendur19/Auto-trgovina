package hr.fer.ris.autotrgovina.service.implementation;

import hr.fer.ris.autotrgovina.entity.Role;
import hr.fer.ris.autotrgovina.entity.User;
import hr.fer.ris.autotrgovina.exception.UsernameAlreadyExistsException;
import hr.fer.ris.autotrgovina.repository.RoleRepository;
import hr.fer.ris.autotrgovina.repository.UserRepository;
import hr.fer.ris.autotrgovina.service.definition.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public User saveUser(User user) {
       if (userRepository.findByUsername(user.getUsername()) != null) {
           throw new UsernameAlreadyExistsException();
       }
       log.info("Saving new user {} to the database",
               user.getFirstName() + user.getLastName());
       return userRepository.save(user);
    }

    @Override
    @Transactional
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    @Transactional
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user with username {}", roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user with username {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
