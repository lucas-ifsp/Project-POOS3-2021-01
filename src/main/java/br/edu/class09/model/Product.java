package br.edu.class09.model;

import java.util.UUID;

public class Product {
    private String name;
    private Double price;
    private Integer quantity;
    private String code;

    public Product(String code, String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this. quantity = quantity;
        this.code = code;
    }

    public Product(String name, Double price, Integer quantity) {
        this(UUID.randomUUID().toString(), name, price, quantity);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", code='" + code + '\'' +
                '}';
    }
}
