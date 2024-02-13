package com.invoiceProject.InvoiceApi.controllers;

import com.invoiceProject.InvoiceApi.dtos.InvoiceDto;
import com.invoiceProject.InvoiceApi.models.InvoiceModel;
import com.invoiceProject.InvoiceApi.services.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins ="*",maxAge = 3600)
@RequestMapping("/invoice")
public class InvoiceController {

    final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/adding-invoice")
    public ResponseEntity<Object> saveInvoice(@RequestBody @Valid InvoiceDto invoiceDto){
        if (invoiceService.existsByInvoiceNumber(invoiceDto.getInvoiceNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Invoice is already in use");
        }

        InvoiceModel invoiceModel = new InvoiceModel();
        BeanUtils.copyProperties(invoiceDto,invoiceModel);
        invoiceModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceService.save(invoiceModel));
    }
    @GetMapping
    public ResponseEntity<Page<InvoiceModel>>getAllInvoices(@PageableDefault(page =0,size =10,sort="id",direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(invoiceService.findAll(pageable));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInvoice(@PathVariable(value ="id") UUID id){
        Optional<InvoiceModel> parkingSpotModelOptional =invoiceService.findById(id);
        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice not found.");
        }
        invoiceService.delete(parkingSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Invoice Deleted");
    }
}
