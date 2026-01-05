package com.rentr.contractor.controller;

import com.rentr.contractor.model.JobOrder;
import com.rentr.contractor.service.JobOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-orders")
@CrossOrigin(origins = "http://localhost:5173")
public class JobOrderController {

    private final JobOrderService jobOrderService;

    public JobOrderController(JobOrderService jobOrderService) {
        this.jobOrderService = jobOrderService;
    }

    @PostMapping
    public JobOrder createJobOrder(@RequestBody JobOrder jobOrder) {
        return jobOrderService.createJobOrder(jobOrder);
    }

    @GetMapping
    public List<JobOrder> getAllJobOrders() {
        return jobOrderService.getAllJobOrders();
    }

    @GetMapping("/approved")
    public List<JobOrder> getApprovedJobOrders() {
        return jobOrderService.getApprovedJobOrders();
    }
}
