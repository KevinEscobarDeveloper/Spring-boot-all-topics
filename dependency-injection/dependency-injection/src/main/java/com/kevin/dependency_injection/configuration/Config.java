package com.kevin.dependency_injection.configuration;

import com.kevin.dependency_injection.models.Item;
import com.kevin.dependency_injection.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource(value="classpath:text.properties", encoding = "UTF-8")
public class Config {

    @Bean
    List<Item> itemsInvoice(){
        Product p1 = new Product();
        p1.setName("Camara sony");
        p1.setPrice(800);
        Product p2 = new Product();
        p2.setName("Bicicleta Bianchi");
        p2.setPrice(1200);
        return Arrays.asList(new Item(p1,2), new Item(p2,4));
    }

    @Primary
    @Bean
    List<Item> itemsInvoiceOffice(){
        Product p1 = new Product();
        p1.setName("Monitos Asus");
        p1.setPrice(700);
        Product p2 = new Product();
        p2.setName("Notebook Razer");
        p2.setPrice(2400);
        Product p3 = new Product();
        p3.setName("Impresora hp");
        p3.setPrice(800);
        Product p4 = new Product();
        p4.setName("Escritorio oficina");
        p4.setPrice(900);
        return Arrays.asList(new Item(p1,2), new Item(p2,4),new Item(p3,4),new Item(p4,4));
    }
}
