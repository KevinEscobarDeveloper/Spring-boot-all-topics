package com.jpa.hibernate.springboot_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PersonDto {
    private String name;
    private String lastName;
}
