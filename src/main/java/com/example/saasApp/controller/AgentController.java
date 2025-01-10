package com.example.saasApp.controller;

import com.example.saasApp.model.Agent;
import com.example.saasApp.repo.AgentRepo;
import com.example.saasApp.service.AgentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("saas/agent")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping ("/create")
    public Agent create (@RequestBody Agent agent){
        return agentService.createAgent(agent);
    }
}
