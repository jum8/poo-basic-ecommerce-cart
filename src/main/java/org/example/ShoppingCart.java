package org.example;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
    private Long id;
    private Customer customer;
    private ShoppingCartStatus shoppingCartStatus;
    private List<CartItem> cartItems;

    public ShoppingCart(Long id, Customer customer) {
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

    public Double calculateTotal() {

        return cartItems.stream().map(cartItem -> cartItem.getProduct().getPrice() * cartItem.getQuantity())
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public void addToCart(Product product, Integer quantity) {
        if(quantity < 0) {
            throw new IllegalArgumentException("Only positive quantities allowed");
        }
        cartItems.add(new CartItem(product, quantity));
    }


    public void print() {
        System.out.println("Cart ID | ID | PRODUCT TYPE | PRODUCT NAME | PRICE");
        cartItems.stream()
                .sorted((item1, item2) -> (int) (item1.getProduct().getPrice() - item2.getProduct().getPrice()))
                .map(item -> id +
                        " | " + item.getProduct().getId() +
                        " | " + item.getProduct().getType() +
                        " | " + item.getProduct().getName() +
                        " | " + item.getProduct().getPrice())
                .forEach(System.out::println);
    }

}
