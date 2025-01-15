package com.example.saasApp.dto;

import com.example.saasApp.dto.agentDto.AgentDto;
import com.example.saasApp.dto.customerDto.CustomerDto;
import com.example.saasApp.model.Agent;
import com.example.saasApp.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public AgentDto mapAgentToDto(Agent agent) {
        AgentDto agentDto = new AgentDto();
        agentDto.setId(agent.getId());
        agentDto.setName(agent.getName());
        agentDto.setCountryCode(agent.getCountryCode());
        agentDto.setPhone(agent.getPhone());
        agentDto.setEmail(agent.getEmail());

        // Map customers if they exist
        List<CustomerDto> customerDtos = agent.getCustomers() != null
                ? agent.getCustomers().stream()
                .map(this::mapCustomerToDto)
                .collect(Collectors.toList())
                : null;
        agentDto.setCustomers(customerDtos);

        return agentDto;
    }

    public CustomerDto mapCustomerToDto (Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setCountryCode(customer.getCountryCode());
        customerDto.setPhone(customer.getPhone());
        customerDto.setStatus(customer.getStatus());
        customerDto.setAgentId(customer.getAgent().getId());

        return customerDto;
    }
}
