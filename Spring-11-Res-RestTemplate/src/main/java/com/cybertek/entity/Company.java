package com.cybertek.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import javax.persistence.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id;
    private String name;
    private String catchPhrase;
    private String bs;
}