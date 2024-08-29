package com.kevin.dependency_injection.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private Product product;
    private Integer quantity;

    public int getImporte(){
        return quantity * product.getPrice();
    }
}
