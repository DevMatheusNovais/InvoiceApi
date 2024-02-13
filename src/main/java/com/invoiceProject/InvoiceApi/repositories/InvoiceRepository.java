package com.invoiceProject.InvoiceApi.repositories;

import com.invoiceProject.InvoiceApi.models.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<InvoiceModel, UUID> {

    boolean existsByInvoiceNumber(String invoiceNumber);
}
