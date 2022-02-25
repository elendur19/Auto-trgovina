package hr.fer.ris.autotrgovina.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class AuthController {

    @GetMapping("/api/authorize")
    public Principal validateLogin(Principal user) {
        log.info("User requested to login.");
        return user;
    }
}
