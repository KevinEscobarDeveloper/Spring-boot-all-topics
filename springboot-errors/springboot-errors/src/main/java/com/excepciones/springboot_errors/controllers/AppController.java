package com.excepciones.springboot_errors.controllers;

import com.excepciones.springboot_errors.exceptions.UserNotFoundException;
import com.excepciones.springboot_errors.models.domain.User;
import com.excepciones.springboot_errors.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public String index() {
        //int value = 100 / 0;
        int value = Integer.parseInt("10X");
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<User> show(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException("El usuario no existe!"));
        return ResponseEntity.ok(user);
    }
}
