package com.example.saasApp.service;

import com.example.saasApp.model.Agent;
import com.example.saasApp.repo.AgentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

    private final AgentRepo agentRepo;

    public AgentService(AgentRepo agentRepo) {
        this.agentRepo = agentRepo;
    }

    public Agent createAgent(Agent agent) {
        Agent agent1 =agentRepo.save(agent);
        return agent1;
    }


//    public void AgentRepo createAgent(Agent agent) {
//        agentRepo.save(agent);
//    }
}
