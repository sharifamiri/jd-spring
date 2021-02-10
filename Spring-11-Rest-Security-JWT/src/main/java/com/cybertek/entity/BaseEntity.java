package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_deleted")
    private Boolean isDeleted;

    @JsonIgnore
    @Column(name = "created_date",nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @JsonIgnore
    @Column(name = "updated_date",nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @JsonIgnore
    @Column(name = "user_created",nullable = false)
    private Integer createUserId;

    @JsonIgnore
    @Column(name = "user_updated",nullable = false)
    private Integer updatedUserId;

    @PrePersist
    private void onPersist(){
        this.createDate = new Date();
        this.updateDate = new Date();
        this.createUserId = 1;
        this.updatedUserId = 1;
    }

    @PreUpdate
    private void onPreUpdate(){
        this.updateDate = new Date();
        this.updatedUserId = 1;
    }

}
