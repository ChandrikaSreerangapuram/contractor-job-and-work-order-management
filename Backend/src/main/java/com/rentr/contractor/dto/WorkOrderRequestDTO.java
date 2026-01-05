package com.rentr.contractor.dto;

import com.rentr.contractor.model.Contractor;
import com.rentr.contractor.model.JobOrder;

public class WorkOrderRequestDTO {
    private Long jobOrderId;
    private Long contractorId;

    // Getters and Setters
    public Long getJobOrderId() {
        return jobOrderId;
    }

    public void setJobOrderId(Long jobOrderId) {
        this.jobOrderId = jobOrderId;
    }

    public Long getContractorId() {
        return contractorId;
    }

    public void setContractorId(Long contractorId) {
        this.contractorId = contractorId;
    }
}
