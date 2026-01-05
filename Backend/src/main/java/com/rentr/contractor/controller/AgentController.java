package com.rentr.contractor.controller;

import com.rentr.contractor.model.Agent;
import com.rentr.contractor.model.JobOrder;
import com.rentr.contractor.service.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/agents")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    // Add Agent (shows saved agent with ID)
    @PostMapping("/add")
    public ResponseEntity<Agent> addAgent(@RequestBody Agent agent) {
        Agent savedAgent = agentService.addAgent(agent);
        return new ResponseEntity<>(savedAgent, HttpStatus.CREATED);
    }

    // Create Job Order (returns saved job order)
    @PostMapping("/jobOrders")
    public ResponseEntity<JobOrder> createJobOrder(@RequestBody JobOrder jobOrder) {
        JobOrder savedJobOrder = agentService.createJobOrder(jobOrder);
        return new ResponseEntity<>(savedJobOrder, HttpStatus.CREATED);
    }

    // Get all job orders
    @GetMapping("/jobOrders")
    public ResponseEntity<List<JobOrder>> getAllJobOrders() {
        return ResponseEntity.ok(agentService.getAllJobOrders());
    }

    // Approve job order
    @PutMapping("/jobOrders/{id}/approve")
    public ResponseEntity<JobOrder> approveJobOrder(@PathVariable Long id) {
        JobOrder approvedJob = agentService.approveJobOrder(id);
        return ResponseEntity.ok(approvedJob);
    }
}
