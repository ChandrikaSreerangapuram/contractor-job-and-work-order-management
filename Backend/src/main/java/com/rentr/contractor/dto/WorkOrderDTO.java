package com.rentr.contractor.dto;

public class WorkOrderDTO {
    private Long contractorId;
    private Long jobOrderId;

    // Getters and Setters
    public Long getContractorId() { return contractorId; }
    public void setContractorId(Long contractorId) { this.contractorId = contractorId; }
    public Long getJobOrderId() { return jobOrderId; }
    public void setJobOrderId(Long jobOrderId) { this.jobOrderId = jobOrderId; }
}
