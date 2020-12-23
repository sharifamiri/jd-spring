package com.cybertek.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "departments")
public class Department {

    @Id
    private String department;

    private String division;

}
