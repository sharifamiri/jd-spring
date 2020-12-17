package com.cybertek.entity;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    private Long id;

    private String street;
    private String zipCode;

    @ManyToOne
    private Person person;
}
