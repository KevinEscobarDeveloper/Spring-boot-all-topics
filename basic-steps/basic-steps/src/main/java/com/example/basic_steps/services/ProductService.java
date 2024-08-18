package com.example.basic_steps.services;

import com.example.basic_steps.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
