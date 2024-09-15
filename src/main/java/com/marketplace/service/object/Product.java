package com.marketplace.service.object;

public class Product {
    
    // Описание товара.
    private int id;
    private String name;
    private String description;
    private int price;
    private boolean stock;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public boolean getStock() {
        return stock;
    }

}
