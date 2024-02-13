package com.invoiceProject.InvoiceApi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_INVOICE")
public class InvoiceModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false,unique = true)
    private String invoiceNumber;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false,length = 130)
    private String insertResponsibleName;

    @Column(nullable = false,length = 130)
    private String operatorResponsibleName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getInsertResponsibleName() {
        return insertResponsibleName;
    }

    public void setInsertResponsibleName(String insertResponsibleName) {
        this.insertResponsibleName = insertResponsibleName;
    }

    public String getOperatorResponsibleName() {
        return operatorResponsibleName;
    }

    public void setOperatorResponsibleName(String operatorResponsibleName) {
        this.operatorResponsibleName = operatorResponsibleName;
    }
}
