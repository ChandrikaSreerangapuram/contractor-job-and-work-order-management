package com.rentr.contractor.model;

import jakarta.persistence.*;

@Entity
@Table(name = "work_orders")
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_order_id")
    private JobOrder jobOrder;

    @ManyToOne
    @JoinColumn(name = "contractor_id")
    private Contractor contractor;

    private String status; // SUBMITTED, APPROVED, REJECTED

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public JobOrder getJobOrder() { return jobOrder; }
    public void setJobOrder(JobOrder jobOrder) { this.jobOrder = jobOrder; }

    public Contractor getContractor() { return contractor; }
    public void setContractor(Contractor contractor) { this.contractor = contractor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
