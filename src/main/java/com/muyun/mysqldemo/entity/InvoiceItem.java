package com.muyun.mysqldemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

import static jakarta.persistence.GenerationType.IDENTITY;


@Getter
@Setter
@Entity
@Table(name = "t_invoice_item")
@EntityListeners(AuditingEntityListener.class)
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Long invoiceId;

    private Long orderId;

    private Long orderItemId;

    private Long productId;

    private String productName;

    private Integer quantity;

    @CreatedDate
    @Column(updatable = false)
    private Instant createdTime;

    @LastModifiedDate
    private Instant updatedTime;

    private Long createdBy;
}
