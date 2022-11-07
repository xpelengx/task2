package com.nphase.entity;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final BigDecimal pricePerUnit;
    private final int quantity;

    public Product(String name, BigDecimal pricePerUnit, int quantity) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }
}
