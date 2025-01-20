package com.example.saasApp.controller;

import com.example.saasApp.dto.agentDto.AgentResponse;
import com.example.saasApp.dto.customerDto.CustomerResponse;
import com.example.saasApp.model.Agent;
import com.example.saasApp.model.Customer;
import com.example.saasApp.service.AgentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("saas/agent")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping ("/create")
    public Agent create (@RequestBody AgentResponse agentResponse){
        return agentService.createAgent(agentResponse);
    }

    @PostMapping ("/create_customer")
    public Customer createCustomer (@RequestBody CustomerResponse customerResponse){
        return agentService.createCustomer(customerResponse);
    }

    @GetMapping ("/{agentId}")
    public AgentResponse getAgent (@PathVariable Long agentId){
        return agentService.getAgent(agentId);
    }

    @GetMapping ("/")
    public List<AgentResponse> getAllAgents(){
        return agentService.getAllAgents();
    }

    @PatchMapping ("/update")
    public Agent update (@RequestBody AgentResponse agentResponse){
        return agentService.upateAgent(agentResponse);
    }

    @DeleteMapping ("/{id}")
    public String delete (@PathVariable Long id){
        return agentService.delete(id);
    }

}
