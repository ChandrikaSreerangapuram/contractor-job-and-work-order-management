package com.rentr.contractor.repository;

import com.rentr.contractor.model.WorkPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface WorkPlanRepository extends JpaRepository<WorkPlan, Long> {
    Optional<WorkPlan> findByWorkOrder_Id(Long workOrderId);
}
