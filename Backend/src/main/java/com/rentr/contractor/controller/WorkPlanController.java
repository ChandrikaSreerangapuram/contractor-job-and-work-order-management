package com.rentr.contractor.controller;

import com.rentr.contractor.dto.WorkPlanRequestDTO;
import com.rentr.contractor.model.WorkPlan;
import com.rentr.contractor.service.WorkPlanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workPlans")
public class WorkPlanController {
    private final WorkPlanService workPlanService;

    public WorkPlanController(WorkPlanService workPlanService) { this.workPlanService = workPlanService; }

    @PostMapping
    public WorkPlan createWorkPlan(@RequestBody WorkPlanRequestDTO requestDTO) {
        return workPlanService.createWorkPlan(requestDTO.getWorkOrderId(), requestDTO.getPlanDetails());
    }

    @GetMapping("/{workOrderId}")
    public WorkPlan getWorkPlan(@PathVariable Long workOrderId) { return workPlanService.getWorkPlanByWorkOrder(workOrderId).orElseThrow(() -> new RuntimeException("WorkPlan not found")); }
}
