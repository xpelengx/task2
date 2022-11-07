package com.nphase.service;

import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;

import java.math.BigDecimal;

public class ShoppingCartService {
    public static BigDecimal DISCOUNT_VALUE = BigDecimal.valueOf(0.1);
    public static int DISCOUNT_AMOUNT = 3;

    public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {
        return shoppingCart.getProducts()
                .stream()
                .map(product -> product.getPricePerUnit()
                        .subtract(calculateDiscount(product))
                        .multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal calculateDiscount(Product product) {
        if (product.getQuantity() > DISCOUNT_AMOUNT) {
            return product.getPricePerUnit().multiply(DISCOUNT_VALUE);
        }
        return BigDecimal.ZERO;
    }
}
