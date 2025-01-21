package com.example.saasApp.service;

import com.example.saasApp.dto.Mapper;
import com.example.saasApp.dto.agentDto.AgentResponse;
import com.example.saasApp.dto.customerDto.CustomerResponse;
import com.example.saasApp.model.Agent;
import com.example.saasApp.model.Customer;
import com.example.saasApp.repo.AgentRepo;
import com.example.saasApp.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentService {

    private final AgentRepo agentRepo;
    private final CustomerRepo customerRepo;
    private final Mapper mapper;

    public AgentService(AgentRepo agentRepo, CustomerRepo customerRepo, Mapper mapper) {
        this.agentRepo = agentRepo;
        this.customerRepo = customerRepo;
        this.mapper = mapper;
    }

    public Agent createAgent(AgentResponse agentResponse) {
        Agent agent = new Agent();
        agent.setId(agentResponse.getId());
        agent.setName(agentResponse.getName());
        agent.setCountryCode(agentResponse.getCountryCode());
        agent.setPhone(agentResponse.getPhone());
        agent.setEmail(agentResponse.getEmail());
//        agent.getCustomers();
        return agentRepo.save(agent);
    }

    public Customer createCustomer(CustomerResponse customerResponse) {
    Agent agent = agentRepo.findById(customerResponse.getAgentId())
            .orElseThrow(() -> new RuntimeException("agent not found with id" + customerResponse.getAgentId()));

    Customer customer = new Customer();
    customer.setAgent(agent);
    customer.setCustomerId(customerResponse.getId());
    customer.setName(customerResponse.getName());
    customer.setEmail(customerResponse.getEmail());
    customer.setCountryCode(customerResponse.getCountryCode());
    customer.setPhone(customerResponse.getPhone());
    customer.setStatus(customerResponse.getStatus());

    return customerRepo.save(customer);
    }

    public AgentResponse getAgent(Long agentId) {
        Agent agent = agentRepo.findById(agentId)
                .orElseThrow(() -> new RuntimeException("agent with not found with " + agentId));
        return mapper.mapAgentToResponse(agent);
    }


    public List<AgentResponse> getAllAgents() {
        return agentRepo.findAll()
                .stream()
                .map(mapper::mapAgentToResponse)
                .collect(Collectors.toList());
    }

    public Agent upateAgent(AgentResponse agentResponse) {
        long id = agentResponse.getId();
        String name = agentResponse.getName();
        long countryCode = agentResponse.getCountryCode();
        long phone = agentResponse.getPhone();
        String email = agentResponse.getEmail();

        Agent existingAgent = agentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("id not found " + id));

        existingAgent.setId(id);
        existingAgent.setName(name);
        existingAgent.setEmail(email);
        existingAgent.setCountryCode(countryCode);
        existingAgent.setPhone(phone);
        agentRepo.save(existingAgent);
        return existingAgent;
    }

    public String delete(Long id) {
         agentRepo.deleteById(id);
         return "deleted Successfully agent with id " + id;
    }
}
