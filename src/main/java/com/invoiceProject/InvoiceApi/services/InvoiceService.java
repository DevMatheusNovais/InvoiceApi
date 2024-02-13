package com.invoiceProject.InvoiceApi.services;

import com.invoiceProject.InvoiceApi.models.InvoiceModel;
import com.invoiceProject.InvoiceApi.repositories.InvoiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class InvoiceService {

    InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public InvoiceModel save(InvoiceModel invoiceModel){
        return invoiceRepository.save(invoiceModel);
    }

    public boolean existsByInvoiceNumber(String invoiceNumber){
        return invoiceRepository.existsByInvoiceNumber(invoiceNumber);
    }

    public void delete(InvoiceModel invoiceModel) {
        invoiceRepository.delete(invoiceModel);
    }

    public Page<InvoiceModel> findAll(Pageable pegeable) {
        return invoiceRepository.findAll(pegeable);
    }

    public Optional<InvoiceModel> findById(UUID id) {

        return invoiceRepository.findById(id);
    }

}
