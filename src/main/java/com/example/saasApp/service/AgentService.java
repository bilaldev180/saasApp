package com.example.saasApp.service;

import com.example.saasApp.dto.Mapper;
import com.example.saasApp.dto.agentDto.AgentDto;
import com.example.saasApp.dto.customerDto.CustomerDto;
import com.example.saasApp.model.Agent;
import com.example.saasApp.model.Customer;
import com.example.saasApp.repo.AgentRepo;
import com.example.saasApp.repo.CustomerRepo;
import org.springframework.stereotype.Service;

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
        agent.getCustomers();
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
    customer.setPhone(customerDto.getPhone());

    return customerRepo.save(customer);
    }

    public AgentDto getAgent(Long agentId) {
        Agent agent = agentRepo.findById(agentId)
                .orElseThrow(() -> new RuntimeException("agent with not found with " + agentId));
        return mapper.mapAgentToDto(agent);
    }

//    public Customer createCustomer(long agentId, Customer customer) {
//        Agent agent = agentRepo.findById(agentId)
//                .orElseThrow(() -> new RuntimeException("Agent not found"));
//        customer.setAgent(agent); // Set the Agent object
//        return customerRepo.save(customer); // Save the customer
//    }



//    public void AgentRepo createAgent(Agent agent) {
//        agentRepo.save(agent);
//    }
}
