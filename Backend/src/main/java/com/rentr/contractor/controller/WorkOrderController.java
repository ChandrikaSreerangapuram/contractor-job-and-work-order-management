package com.rentr.contractor.controller;

import com.rentr.contractor.dto.WorkOrderRequestDTO;
import com.rentr.contractor.model.WorkOrder;
import com.rentr.contractor.service.WorkOrderService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work-orders")
@CrossOrigin(origins = "http://localhost:5173")
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    public WorkOrderController(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }

    // Contractor applies for a job
    @PostMapping
    public WorkOrder create(@RequestBody WorkOrderRequestDTO requestDTO) {
        return workOrderService.createWorkOrder(requestDTO);
    }

    // Agent views all work orders
    @GetMapping
    public List<WorkOrder> getAll() {
        return workOrderService.getAllWorkOrders(); // Delegate to service
    }

    // Agent approves work order
    @PutMapping("/{id}/approve")
    public WorkOrder approve(@PathVariable Long id) {
        return workOrderService.approveWorkOrder(id); // Delegate to service
    }

    @PutMapping("/{id}/reject")
    public WorkOrder reject(@PathVariable Long id) {
        return workOrderService.rejectWorkOrder(id);
    }

    @GetMapping("/pending")
    public List<WorkOrder> getPending() {
        return workOrderService.getPendingWorkOrders();
    }

    @GetMapping("/contractor/{contractorId}")
    public List<WorkOrder> getByContractor(@PathVariable Long contractorId) {
        return workOrderService.getWorkOrdersByContractor(contractorId);
    }
}
