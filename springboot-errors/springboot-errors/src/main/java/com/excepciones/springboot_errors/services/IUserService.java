package com.excepciones.springboot_errors.services;

import com.excepciones.springboot_errors.models.domain.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();
    Optional<User> findById(Long id);
}
