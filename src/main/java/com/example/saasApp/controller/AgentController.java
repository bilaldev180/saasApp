package com.example.saasApp.controller;

import com.example.saasApp.dto.agentDto.AgentDto;
import com.example.saasApp.dto.customerDto.CustomerDto;
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

    @GetMapping ("/")
    public List<AgentDto> getAllAgents(){
        return agentService.getAllAgents();
    }

    @PatchMapping ("/update")
    public Agent update (@RequestBody AgentDto agentDto){
        return agentService.upateAgent(agentDto);
    }
}
