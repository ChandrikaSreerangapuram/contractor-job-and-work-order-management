package com.rentr.contractor.service;

import com.rentr.contractor.model.JobOrder;
import com.rentr.contractor.repository.JobOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobOrderService {

    private final JobOrderRepository jobOrderRepository;

    public JobOrderService(JobOrderRepository jobOrderRepository) {
        this.jobOrderRepository = jobOrderRepository;
    }

    public List<JobOrder> getAllJobOrders() {
        return jobOrderRepository.findAll();
    }

    public JobOrder createJobOrder(JobOrder jobOrder) {
        return jobOrderRepository.save(jobOrder);
    }

    public List<JobOrder> getApprovedJobOrders() {
        return jobOrderRepository.findByApprovedTrue();
    }
}
