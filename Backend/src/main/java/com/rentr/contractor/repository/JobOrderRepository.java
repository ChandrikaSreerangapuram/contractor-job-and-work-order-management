package com.rentr.contractor.repository;

import com.rentr.contractor.model.JobOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobOrderRepository extends JpaRepository<JobOrder, Long> {
    List<JobOrder> findByApprovedTrue();
}
