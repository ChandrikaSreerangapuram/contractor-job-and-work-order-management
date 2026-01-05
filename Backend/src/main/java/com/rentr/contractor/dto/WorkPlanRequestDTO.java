package com.rentr.contractor.dto;

public class WorkPlanRequestDTO {
    private Long workOrderId;
    private String planDetails;

    // Getters and Setters
    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getPlanDetails() {
        return planDetails;
    }

    public void setPlanDetails(String planDetails) {
        this.planDetails = planDetails;
    }
}
