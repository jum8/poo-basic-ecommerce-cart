package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class CartItem {
    private Product product;
    private Integer quantity;

    public Product getProduct() {
        return product;
    }

    public CartItem(Product product, Integer quantity) {
        if(Objects.isNull(product)) throw new IllegalArgumentException("Product is a required field");
        if(Objects.isNull(quantity)) throw new IllegalArgumentException("Quantity is a required field");
        if(quantity < 1) throw new IllegalArgumentException("Quantity must be a positive number");

        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal getTotal(){
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(product, cartItem.product) && Objects.equals(quantity, cartItem.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }
}
