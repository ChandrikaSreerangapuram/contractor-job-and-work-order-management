package com.rentr.contractor.service;

import com.rentr.contractor.model.*;
import com.rentr.contractor.repository.*;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class WorkPlanService {
    private final WorkPlanRepository workPlanRepo;
    private final WorkOrderRepository workOrderRepo;

    public WorkPlanService(WorkPlanRepository workPlanRepo, WorkOrderRepository workOrderRepo) {
        this.workPlanRepo = workPlanRepo;
        this.workOrderRepo = workOrderRepo;
    }

    public WorkPlan createWorkPlan(Long workOrderId, String planDetails) {
        WorkOrder workOrder = workOrderRepo.findById(workOrderId).orElseThrow();
        WorkPlan wp = new WorkPlan();
        wp.setWorkOrder(workOrder);
        wp.setPlanDetails(planDetails);
        return workPlanRepo.save(wp);
    }

    public Optional<WorkPlan> getWorkPlanByWorkOrder(Long workOrderId) { return workPlanRepo.findByWorkOrder_Id(workOrderId); }
}
