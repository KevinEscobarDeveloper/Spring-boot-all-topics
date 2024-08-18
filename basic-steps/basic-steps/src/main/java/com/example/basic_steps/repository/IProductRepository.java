package com.example.basic_steps.repository;

import com.example.basic_steps.models.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
