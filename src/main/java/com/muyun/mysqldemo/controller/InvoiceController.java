package com.muyun.mysqldemo.controller;

import com.muyun.mysqldemo.entity.Invoice;
import com.muyun.mysqldemo.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceRepository invoiceRepository;

    @GetMapping
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @GetMapping(params = "createdBy")
    public List<Invoice> findAllByCreatedBy(@RequestParam Long createdBy) {
        return invoiceRepository.findAllByCreatedBy(createdBy);
    }


    @GetMapping("/{id}")
    public Optional<Invoice> findById(@PathVariable Long id) {
        return invoiceRepository.findById(id);
    }

    @GetMapping(path = "/{id}", params = "createdBy")
    public Optional<Invoice> findById(@PathVariable Long id, @RequestParam Long createdBy) {
        invoiceRepository.findByInvoiceIdAndCreatedByAndInvoiceItemsInvoiceId(id, createdBy);
        invoiceRepository.findByInvoiceIdAndCreatedByAndInvoiceItems_InvoiceId(id, createdBy, id);

        return invoiceRepository.findByInvoiceIdAndCreatedBy(id, createdBy);
    }


    @PostMapping
    public Invoice save(@RequestBody Invoice invoice) {
        return invoiceRepository.save(invoice);
    }


}
