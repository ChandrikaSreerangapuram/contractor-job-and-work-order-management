package com.rentr.contractor.service;

import com.rentr.contractor.dto.WorkOrderRequestDTO;
import com.rentr.contractor.model.Contractor;
import com.rentr.contractor.model.JobOrder;
import com.rentr.contractor.model.WorkOrder;
import com.rentr.contractor.repository.ContractorRepository;
import com.rentr.contractor.repository.JobOrderRepository;
import com.rentr.contractor.repository.WorkOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderService {

    private final WorkOrderRepository workOrderRepository;
    private final JobOrderRepository jobOrderRepository;
    private final ContractorRepository contractorRepository;

    public WorkOrderService(WorkOrderRepository workOrderRepository,
                            JobOrderRepository jobOrderRepository,
                            ContractorRepository contractorRepository) {
        this.workOrderRepository = workOrderRepository;
        this.jobOrderRepository = jobOrderRepository;
        this.contractorRepository = contractorRepository;
    }

    public WorkOrder createWorkOrder(WorkOrderRequestDTO requestDTO) {
        JobOrder jobOrder = jobOrderRepository.findById(requestDTO.getJobOrderId())
                .orElseThrow(() -> new RuntimeException("JobOrder not found"));
        Contractor contractor = contractorRepository.findById(requestDTO.getContractorId())
                .orElseThrow(() -> new RuntimeException("Contractor not found"));

        WorkOrder workOrder = new WorkOrder();
        workOrder.setJobOrder(jobOrder);
        workOrder.setContractor(contractor);
        workOrder.setStatus("PENDING"); // Initial status

        return workOrderRepository.save(workOrder);
    }

    public List<WorkOrder> getAllWorkOrders() {
        return workOrderRepository.findAll();
    }

    public WorkOrder approveWorkOrder(Long id) {
        WorkOrder wo = workOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("WorkOrder not found"));
        wo.setStatus("APPROVED");
        return workOrderRepository.save(wo);
    }

    public WorkOrder rejectWorkOrder(Long id) {
        WorkOrder wo = workOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("WorkOrder not found"));
        wo.setStatus("REJECTED");
        return workOrderRepository.save(wo);
    }

    public List<WorkOrder> getPendingWorkOrders() {
        return workOrderRepository.findByStatus("PENDING");
    }

    public List<WorkOrder> getWorkOrdersByContractor(Long contractorId) {
        return workOrderRepository.findByContractorId(contractorId);
    }
}
