package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private Long id;
    private String name;
    private String description;

    private BigDecimal price;
    private ProductType type;

    public Long getId() {
        return id;
    }

    public ProductType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product(Long id, String name, String description, BigDecimal price, ProductType type) {

        if(Objects.isNull(price)) throw new IllegalArgumentException("Price is a required field");
        if(Objects.isNull(name)) throw new IllegalArgumentException("Name is a required field");
        if(Objects.isNull(description)) throw new IllegalArgumentException("Description is a required field");
        if(Objects.isNull(type)) throw new IllegalArgumentException("Type is a required field");

        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && type == product.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, type);
    }
}
