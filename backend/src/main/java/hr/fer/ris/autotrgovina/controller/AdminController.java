package hr.fer.ris.autotrgovina.controller;

import hr.fer.ris.autotrgovina.entity.Admin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/validateLogin")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AdminController {

    @GetMapping()
    public Admin validateLogin() {
        return new Admin("User successfully authenticated");
    }
}
