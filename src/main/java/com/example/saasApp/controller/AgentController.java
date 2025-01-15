package com.example.saasApp.controller;

import com.example.saasApp.dto.agentDto.AgentDto;
import com.example.saasApp.dto.customerDto.CustomerDto;
import com.example.saasApp.model.Agent;
import com.example.saasApp.model.Customer;
import com.example.saasApp.repo.AgentRepo;
import com.example.saasApp.service.AgentService;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("saas/agent")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping ("/create")
    public Agent create (@RequestBody AgentDto agentDto){
        return agentService.createAgent(agentDto);
    }

    @PostMapping ("/create_customer")
    public Customer createCustomer (@RequestBody CustomerDto customerDto){
        return agentService.createCustomer(customerDto);
    }

    @GetMapping ("/{agentId}")
    public AgentDto getAgent (@PathVariable Long agentId){
        return agentService.getAgent(agentId);
    }
}
