package org.example;

import java.util.Comparator;

public class Printer {
    static void print(ShoppingCart shoppingCart) {
        System.out.printf("%-8s | %-5s | %-15s | %-30s | %-10s%n", "Cart ID", "ID", "PRODUCT TYPE", "PRODUCT NAME", "PRICE");
        shoppingCart.getCartItems().stream()
                .sorted(Comparator.comparing(item -> item.getProduct().getPrice()))
                .map(item -> String.format("%8s | %5s | %-15s | %-30s | %10.2f",
                        shoppingCart.getId(),
                        item.getProduct().getId(),
                        item.getProduct().getType().label,
                        item.getProduct().getName(),
                        item.getProduct().getPrice()))
                .forEach(System.out::println);
    }
}
