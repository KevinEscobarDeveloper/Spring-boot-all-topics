package com.example.basic_steps.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.example.basic_steps.models.Product;
import java.util.Arrays;
import java.util.List;

@Repository("productList")

public class ProductRepositoryImpl implements  IProductRepository{

    private final List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L,"Memoria consair 32",300L),
                new Product(2L,"Cpu Intel core i9",400L),
                new Product(3L,"Teclado Razer mini",500L),
                new Product(4L,"Motherboard Gigabyte",600L)
        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }

    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
