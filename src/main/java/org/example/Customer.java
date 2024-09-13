package org.example;

import java.time.LocalDate;

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
}
