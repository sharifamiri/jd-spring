package com.cybertek.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cinema extends BaseEntity {

    private String name;
    private String sponsoredName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

    public Cinema(String name, String sponsoredName) {
        this.name = name;
        this.sponsoredName = sponsoredName;
    }
}
