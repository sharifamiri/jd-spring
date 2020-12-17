package com.cybertek.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Address {

    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String zipCode;

    @ManyToOne
    private Person person;
}
