package com.muyun.mysqldemo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.Instant;

import static jakarta.persistence.GenerationType.IDENTITY;


@Data
@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String operation;

    @CreatedDate
    @Column(updatable = false)
    private Instant createdTime;

    @CreatedBy
    private Long createdBy;
}
