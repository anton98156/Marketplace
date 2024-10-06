package com.marketplace.service.object;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    
    // Описание товара.
    private int id;
    private String name;
    private String description;
    private int price;
    private boolean stock;

}
