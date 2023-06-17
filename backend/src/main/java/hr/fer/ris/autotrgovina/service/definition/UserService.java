package hr.fer.ris.autotrgovina.service.definition;

import hr.fer.ris.autotrgovina.entity.Role;
import hr.fer.ris.autotrgovina.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
