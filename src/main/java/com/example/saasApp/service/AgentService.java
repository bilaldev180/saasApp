package com.example.saasApp.service;

import com.example.saasApp.dto.Mapper;
import com.example.saasApp.dto.agentDto.AgentDto;
import com.example.saasApp.dto.customerDto.CustomerDto;
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

    public Agent createAgent(AgentDto agentDto) {
        Agent agent = new Agent();
        agent.setId(agentDto.getId());
        agent.setName(agentDto.getName());
        agent.setCountryCode(agentDto.getCountryCode());
        agent.setPhone(agentDto.getPhone());
        agent.setEmail(agentDto.getEmail());
//        agent.getCustomers();
        return agentRepo.save(agent);
    }

    public Customer createCustomer(CustomerDto customerDto) {
    Agent agent = agentRepo.findById(customerDto.getAgentId())
            .orElseThrow(() -> new RuntimeException("agent not found with id" + customerDto.getAgentId()));

    Customer customer = new Customer();
    customer.setAgent(agent);
    customer.setId(customerDto.getId());
    customer.setName(customerDto.getName());
    customer.setEmail(customerDto.getEmail());
    customer.setCountryCode(customerDto.getCountryCode());
    customer.setPhone(customerDto.getPhone());
    customer.setStatus(customerDto.getStatus());

    return customerRepo.save(customer);
    }

    public AgentDto getAgent(Long agentId) {
        Agent agent = agentRepo.findById(agentId)
                .orElseThrow(() -> new RuntimeException("agent with not found with " + agentId));
        return mapper.mapAgentToDto(agent);
    }


    public List<AgentDto> getAllAgents() {
        return agentRepo.findAll()
                .stream()
                .map(mapper::mapAgentToDto)
                .collect(Collectors.toList());
    }

    public Agent upateAgent(AgentDto agentDto) {
        long id = agentDto.getId();
        String name = agentDto.getName();
        long countryCode = agentDto.getCountryCode();
        long phone = agentDto.getPhone();
        String email = agentDto.getEmail();

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
}
