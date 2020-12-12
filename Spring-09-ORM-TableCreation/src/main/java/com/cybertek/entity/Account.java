package com.cybertek.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@MappedSuperclass
public class Account {

    @Id
    private Long id;

    private String owner;
    private BigDecimal balance;
    protected BigDecimal interestRate;
}
