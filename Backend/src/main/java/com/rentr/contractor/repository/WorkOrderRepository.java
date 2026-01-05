package com.rentr.contractor.repository;

import com.rentr.contractor.model.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {

    List<WorkOrder> findByContractorId(Long contractorId);
    List<WorkOrder> findByStatus(String status);
}
