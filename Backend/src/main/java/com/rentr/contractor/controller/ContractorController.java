package com.rentr.contractor.controller;

import com.rentr.contractor.model.*;
import com.rentr.contractor.service.ContractorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contractors")
public class ContractorController {
    private final ContractorService contractorService;

    public ContractorController(ContractorService contractorService) { this.contractorService = contractorService; }

    @PostMapping("/add")
    public Contractor addContractor(@RequestBody Contractor contractor) { return contractorService.addContractor(contractor); }

    @GetMapping("/jobOrders")
    public List<JobOrder> searchJobOrders() { return contractorService.searchJobOrders(); }

    @PostMapping("/{contractorId}/apply/{jobOrderId}")
    public WorkOrder submitWorkOrder(@PathVariable Long contractorId, @PathVariable Long jobOrderId) {
        return contractorService.submitWorkOrder(contractorId, jobOrderId);
    }
}
