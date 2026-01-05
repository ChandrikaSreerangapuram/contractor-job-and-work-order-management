package com.rentr.contractor.service;

import com.rentr.contractor.model.*;
import com.rentr.contractor.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContractorService {
    private final ContractorRepository contractorRepo;
    private final JobOrderRepository jobOrderRepo;
    private final WorkOrderRepository workOrderRepo;

    public ContractorService(ContractorRepository contractorRepo,
                             JobOrderRepository jobOrderRepo,
                             WorkOrderRepository workOrderRepo) {
        this.contractorRepo = contractorRepo;
        this.jobOrderRepo = jobOrderRepo;
        this.workOrderRepo = workOrderRepo;
    }

    public Contractor addContractor(Contractor contractor) { return contractorRepo.save(contractor); }

    public List<JobOrder> searchJobOrders() { return jobOrderRepo.findByApprovedTrue(); }

    public WorkOrder submitWorkOrder(Long contractorId, Long jobOrderId) {
        Contractor contractor = contractorRepo.findById(contractorId).orElseThrow();
        JobOrder jobOrder = jobOrderRepo.findById(jobOrderId).orElseThrow();
        WorkOrder workOrder = new WorkOrder();
        workOrder.setContractor(contractor);
        workOrder.setJobOrder(jobOrder);
        return workOrderRepo.save(workOrder);
    }
}
