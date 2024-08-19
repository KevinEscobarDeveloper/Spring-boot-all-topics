package com.example.basic_steps;

import com.example.basic_steps.repository.IProductRepository;
import com.example.basic_steps.repository.ProductRepositoryJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {
    @Bean
    public IProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}
