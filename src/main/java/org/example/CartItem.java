package org.example;

public class CartItem {
    private Product product;
    private Integer quantity;

    public Product getProduct() {
        return product;
    }

    public CartItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
