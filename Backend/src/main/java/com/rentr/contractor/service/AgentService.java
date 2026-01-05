package com.rentr.contractor.service;

import com.rentr.contractor.model.Agent;
import com.rentr.contractor.model.JobOrder;
import com.rentr.contractor.repository.AgentRepository;
import com.rentr.contractor.repository.JobOrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AgentService {
    private final AgentRepository agentRepo;
    private final JobOrderRepository jobOrderRepo;

    public AgentService(AgentRepository agentRepo, JobOrderRepository jobOrderRepo) {
        this.agentRepo = agentRepo;
        this.jobOrderRepo = jobOrderRepo;
    }

    public Agent addAgent(Agent agent) { return agentRepo.save(agent); }
    public JobOrder createJobOrder(JobOrder jobOrder) { return jobOrderRepo.save(jobOrder); }
    public List<JobOrder> getAllJobOrders() { return jobOrderRepo.findAll(); }
    public JobOrder approveJobOrder(Long jobOrderId) {
        JobOrder jobOrder = jobOrderRepo.findById(jobOrderId).orElseThrow();
        jobOrder.setApproved(true);
        return jobOrderRepo.save(jobOrder);
    }
}
