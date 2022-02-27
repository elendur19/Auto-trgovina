package hr.fer.ris.autotrgovina.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleRequest {
    private String username;
    private String roleName;
}
