package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ShoppingCart {
    private Long id;
    private Customer customer;
    private ShoppingCartStatus shoppingCartStatus;
    private List<CartItem> cartItems;

    public ShoppingCart(Long id, Customer customer) {
        if (Objects.isNull(customer)) throw new IllegalArgumentException("Customer cannot be null");
        this.id = id;
        this.customer = customer;
        this.shoppingCartStatus = ShoppingCartStatus.DRAFT;
        this.cartItems = new ArrayList<>();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public Long getId() {
        return id;
    }

    public void submit() {
        shoppingCartStatus = ShoppingCartStatus.SUBMITTED;
    }

    public BigDecimal getTotal() {
        return cartItems.stream().map(CartItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalOfProductType(ProductType type) {
        return cartItems.stream().filter(cartItem -> cartItem.getProduct().getType().equals(type))
                .map(CartItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addToCart(Product product, Integer quantity) {
        cartItems.add(new CartItem(product, quantity));
    }


    public List<Product> getProductsBy(List<Predicate<Product>> predicates) {
        return cartItems.stream().map(CartItem::getProduct)
                .filter(predicates.stream().reduce(p -> true, Predicate::and))
                .collect(Collectors.toList());
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
