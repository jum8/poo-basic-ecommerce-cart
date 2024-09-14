package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ShoppingCart {
    private Long id;
    private Customer customer;
    private ShoppingCartStatus shoppingCartStatus;
    private List<CartItem> cartItems;

    public ShoppingCart(Long id, Customer customer) {
        if(Objects.isNull(customer)) throw new IllegalArgumentException("Customer cannot be null");
        this.id = id;
        this.customer = customer;
        this.shoppingCartStatus = ShoppingCartStatus.DRAFT;
        this.cartItems = new ArrayList<>();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void submit() {
        shoppingCartStatus = ShoppingCartStatus.SUBMITTED;
    }

    public BigDecimal getTotal() {
        return cartItems.stream().map(CartItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addToCart(Product product, Integer quantity) {
        cartItems.add(new CartItem(product, quantity));
    }

    public void print() {
        System.out.println("Cart ID | ID | PRODUCT TYPE | PRODUCT NAME | PRICE");
        cartItems.stream()
                .sorted((item1, item2) -> item1.getProduct().getPrice().compareTo(item2.getProduct().getPrice()))
                .map(item -> id +
                        " | " + item.getProduct().getId() +
                        " | " + item.getProduct().getType() +
                        " | " + item.getProduct().getName() +
                        " | " + item.getProduct().getPrice())
                .forEach(System.out::println);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(id, that.id) && Objects.equals(customer, that.customer) && shoppingCartStatus == that.shoppingCartStatus && Objects.equals(cartItems, that.cartItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, shoppingCartStatus, cartItems);
    }
}
