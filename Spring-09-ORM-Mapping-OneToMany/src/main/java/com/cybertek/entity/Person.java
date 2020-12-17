package com.cybertek.entity;


import javax.persistence.*;
import java.util.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "person")
    private List<Address> addresses;

//        @OneToMany
//        @JoinColumn(name = "person_id")
//        private List<Address> addresses;
}
