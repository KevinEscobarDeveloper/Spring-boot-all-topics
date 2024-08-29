package com.kevin.dependency_injection.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Component
@Getter
@Setter
@RequestScope
//@JsonIgnoreProperties({"targetSource","advisors"})
public class Invoice {
    @Autowired
    private Client client;
    @Value("${invoice.description}")
    private String description;
    @Autowired
    private List<Item> items;

    @PostConstruct
    public void init(){
        client.setName(client.getName() + " post constructor");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destruyendo el componente o bean invoice");
    }

    public int getTotal(){
        return items.stream()
                .map(item -> item.getImporte())
                .reduce(0, (subtotal, importe) -> subtotal + importe);
    }
}
