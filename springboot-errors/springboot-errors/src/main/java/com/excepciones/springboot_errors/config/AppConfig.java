package com.excepciones.springboot_errors.config;

import com.excepciones.springboot_errors.models.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<User> users() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "kevin", "Escobar"));
        users.add(new User(2L, "Pepe", "Gonzales"));
        users.add(new User(3L, "Maria", "Perez"));
        return users;
    }
}
