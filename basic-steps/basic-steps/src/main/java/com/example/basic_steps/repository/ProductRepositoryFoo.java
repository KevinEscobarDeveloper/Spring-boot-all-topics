package com.example.basic_steps.repository;

import com.example.basic_steps.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Primary
public class ProductRepositoryFoo implements  IProductRepository{


    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L,"Monitor Asus 27", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id,"Monitor Asus 27", 600L);
    }
}
