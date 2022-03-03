package hr.fer.ris.autotrgovina.controller;

import hr.fer.ris.autotrgovina.entity.User;
import hr.fer.ris.autotrgovina.model.UserRequest;
import hr.fer.ris.autotrgovina.service.definition.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

/*    @GetMapping("/api/authorize")
    public Principal validateLogin(Principal user) {
        log.info("User requested to login.");
        return user;
    }*/

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok().body(userService.saveUser(request));
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.refreshToken(request, response);
    }
}
