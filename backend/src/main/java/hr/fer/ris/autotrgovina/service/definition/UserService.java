package hr.fer.ris.autotrgovina.service.definition;

import hr.fer.ris.autotrgovina.entity.Role;
import hr.fer.ris.autotrgovina.entity.User;
import hr.fer.ris.autotrgovina.model.UserRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface UserService {
    User saveUser(UserRequest request);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    // usually methods like this should return Page
    List<User> getUsers();
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
