package com.muyun.mysqldemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;


@Getter
@Setter
@Entity
@Table(name = "t_invoice")
@EntityListeners(AuditingEntityListener.class)
public class Invoice {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long invoiceId;

    private Long orderId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoiceId")
    private List<InvoiceItem> invoiceItems;

    @CreatedDate
    @Column(updatable = false)
    private Instant createdTime;

    @LastModifiedDate
    private Instant updatedTime;

    private Long createdBy;
}
