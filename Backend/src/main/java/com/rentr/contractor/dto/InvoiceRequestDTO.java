package com.rentr.contractor.dto;

public class InvoiceRequestDTO {
    private Long workOrderId;
    private Double amount;

    // Getters and Setters
    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
