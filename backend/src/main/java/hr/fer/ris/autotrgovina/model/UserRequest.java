package hr.fer.ris.autotrgovina.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
