package com.cybertek.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "regions")
public class Region extends BaseEntity {

    private String region;
    private String country;
}
