package com.payoneer.payoneerchallenge.models;

import java.util.Objects;

public class Product {

    private String productName;

    private String productPrice;

    private int id;

    public Product(String productName, String productPrice, int id) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.id = id;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId() == product.getId() &&
                getProductName().equals(product.getProductName()) &&
                getProductPrice().equals(product.getProductPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductName(), getProductPrice(), getId());
    }
}
