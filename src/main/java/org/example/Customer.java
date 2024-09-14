package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Customer {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phone;

    public Customer(Long id, String name, String lastName, LocalDate birthDate, String email, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(lastName, customer.lastName) && Objects.equals(birthDate, customer.birthDate) && Objects.equals(email, customer.email) && Objects.equals(phone, customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, birthDate, email, phone);
    }
}
