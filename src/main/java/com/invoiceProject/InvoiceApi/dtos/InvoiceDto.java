package com.invoiceProject.InvoiceApi.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class InvoiceDto {

    @NotBlank
    private String invoiceNumber;

    @NotBlank
    private String insertResponsibleName;

    private String operatorResponsibleName;

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
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
