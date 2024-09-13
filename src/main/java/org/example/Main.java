package org.example;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Customer john = new Customer(1L, "John", "Smith", LocalDate.parse("1980-01-01"), "js@mail.com", "03417143334");

        Map<Long, Product> products = new HashMap<>();


        products.put(1L, new Product(1L, "Smartphone", "Smartphone Samsung Galaxy S21", 1200.0, ProductType.ELECTRONIC));
        products.put(2L, new Product(2L, "Laptop", "Laptop Dell Inspiron 15", 2500.0, ProductType.ELECTRONIC));
        products.put(3L, new Product(3L, "Tablet", "Tablet Apple iPad Air", 1800.0, ProductType.ELECTRONIC));
        products.put(4L, new Product(4L, "Smartwatch", "Smartwatch Apple Watch Series 6", 1500.0, ProductType.ELECTRONIC));
        products.put(5L, new Product(5L, "Headphones", "Auriculares Sony WH-1000XM4", 350.0, ProductType.ELECTRONIC));


        products.put(6L, new Product(6L, "Libro de Java", "Java: A Beginner's Guide", 45.0, ProductType.LIBRARY));
        products.put(7L, new Product(7L, "Diccionario Inglés-Español", "Oxford English-Spanish Dictionary", 60.0, ProductType.LIBRARY));
        products.put(8L, new Product(8L, "Revista de Ciencia", "National Geographic - Edición Especial", 30.0, ProductType.LIBRARY));
        products.put(9L, new Product(9L, "Enciclopedia", "Enciclopedia Británica - Volumen 1", 102.0, ProductType.LIBRARY));
        products.put(10L, new Product(10L, "Libro de Programación", "Clean Code: A Handbook of Agile Software Craftsmanship", 105.0, ProductType.LIBRARY));


        products.put(11L, new Product(11L, "Taza", "Taza de cerámica personalizada", 12.0, ProductType.OTHERS));
        products.put(12L, new Product(12L, "Agenda 2024", "Agenda de cuero con calendario 2024", 25.0, ProductType.OTHERS));
        products.put(13L, new Product(13L, "Bolígrafo", "Bolígrafo Parker con tinta azul", 15.0, ProductType.OTHERS));
        products.put(14L, new Product(14L, "Gafas de Sol", "Gafas de sol Ray-Ban modelo aviador", 150.0, ProductType.OTHERS));
        products.put(15L, new Product(15L, "Botella de Agua", "Botella de agua reutilizable de acero inoxidable", 20.0, ProductType.OTHERS));

        ShoppingCart shoppingCart1 = new ShoppingCart(1L, john);
        shoppingCart1.addToCart(products.get(1L), 1);
        shoppingCart1.addToCart(products.get(2L), 1);
        shoppingCart1.addToCart(products.get(3L), 1);
        shoppingCart1.addToCart(products.get(5L), 1);

        ShoppingCart shoppingCart2 = new ShoppingCart(2L, john);
        shoppingCart2.addToCart(products.get(6L), 1);
        shoppingCart2.addToCart(products.get(8L), 1);
        shoppingCart2.addToCart(products.get(9L), 1);

        ShoppingCart shoppingCart3 = new ShoppingCart(3L, john);
        shoppingCart3.addToCart(products.get(14L), 1);

        ShoppingCart shoppingCart4 = new ShoppingCart(4L, john);
        shoppingCart4.addToCart(products.get(1L), 1);
        shoppingCart4.addToCart(products.get(2L), 1);
        shoppingCart4.addToCart(products.get(4L), 1);
        shoppingCart4.addToCart(products.get(7L), 1);
        shoppingCart4.addToCart(products.get(9L), 1);
        shoppingCart4.addToCart(products.get(10L), 1);
        shoppingCart4.addToCart(products.get(11L), 2);
        shoppingCart4.addToCart(products.get(14L), 1);
        shoppingCart4.addToCart(products.get(15L), 3);


        System.out.println("1. Calculate and Print all products with price > 100 and product type is library");
        shoppingCart4.getCartItems().stream().map(CartItem::getProduct)
                .filter(product -> product.getPrice() > 100.0)
                .filter(product -> product.getType().equals(ProductType.LIBRARY))
                .forEach(System.out::println);


        System.out.println("2. Calculate and Print sum(price) of all products");
        System.out.printf("The total sum of all products is: %.2f%n", shoppingCart4.calculateTotal());

        System.out.println("3. Calculate and Print sum(price) of all electronic products");
        Double totalSumElectronics = shoppingCart4.getCartItems().stream()
                .filter(cartItem -> cartItem.getProduct().getType().equals(ProductType.ELECTRONIC))
                .map(cartItem -> cartItem.getProduct().getPrice() * cartItem.getQuantity())
                .mapToDouble(Double::doubleValue)
                .sum();
        System.out.printf("The total sum of all electronic products is: %.2f%n", totalSumElectronics);

        System.out.println("4. Calculate and Print all information of the shopping cart ordered by price");
        shoppingCart4.print();


    }
}