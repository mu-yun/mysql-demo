package com.muyun.mysqldemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "t_address")
public class Address {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String province;

    private String city;
}
