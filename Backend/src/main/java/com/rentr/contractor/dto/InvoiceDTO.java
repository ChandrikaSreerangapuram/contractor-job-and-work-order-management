package com.rentr.contractor.dto;

public class InvoiceDTO {
    private Long workOrderId;
    private double amount;

    // Getters and Setters
    public Long getWorkOrderId() { return workOrderId; }
    public void setWorkOrderId(Long workOrderId) { this.workOrderId = workOrderId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
