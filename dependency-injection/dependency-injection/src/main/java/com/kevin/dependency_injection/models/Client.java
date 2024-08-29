package com.kevin.dependency_injection.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@Component
@SessionScope
//@JsonIgnoreProperties({"targetSource","advisors"})
public class Client {
    @Value("${client.name}")
    private String name;
    @Value("${client.lastname}")
    private String lastName;

}
