package com.muyun.mysqldemo.repository;

import com.muyun.mysqldemo.entity.Invoice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


    @EntityGraph(attributePaths = "invoiceItems")
    List<Invoice> findAllByCreatedBy(Long createdBy);

    @EntityGraph(attributePaths = "invoiceItems")
    Optional<Invoice> findByInvoiceIdAndCreatedBy(Long invoiceId, Long createdBy);

    @EntityGraph(attributePaths = "invoiceItems")
    Optional<Invoice> findByInvoiceIdAndCreatedByAndInvoiceItems_InvoiceId(Long id, Long createdBy, Long invoiceId);

    @Query("select invoice,invoiceItem " +
            "from Invoice invoice " +
            "left join InvoiceItem invoiceItem on invoice.invoiceId=invoiceItem.invoiceId " +
            "where invoice.invoiceId=:invoiceId and invoice.createdBy=:createdBy and invoiceItem.invoiceId=:invoiceId")
    Optional<Invoice> findByInvoiceIdAndCreatedByAndInvoiceItemsInvoiceId(@Param("invoiceId") Long invoiceId,
                                                                          @Param("createdBy") Long createdBy);


}
