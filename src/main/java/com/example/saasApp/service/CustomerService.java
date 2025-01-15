package com.example.saasApp.service;

import com.example.saasApp.dto.Mapper;
import com.example.saasApp.dto.customerDto.CustomerDto;
import com.example.saasApp.model.Agent;
import com.example.saasApp.model.Customer;
import com.example.saasApp.repo.AgentRepo;
import com.example.saasApp.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final AgentRepo agentRepo;
    private final Mapper mapper;

    public CustomerService(CustomerRepo customerRepo, AgentRepo agentRepo, Mapper mapper) {
        this.customerRepo = customerRepo;
        this.agentRepo = agentRepo;
        this.mapper = mapper;
    }

    public Customer create(CustomerDto customerDto) {
       Agent agent = agentRepo.findById(customerDto.getAgentId())
               .orElseThrow(() -> new RuntimeException("agent not found with id " + customerDto.getAgentId()));
        Customer customer = new Customer();

        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setCountryCode(customerDto.getCountryCode());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setStatus(customerDto.getStatus());
        customer.setAgent(agent);

        return customerRepo.save(customer);
    }

    public Customer update(CustomerDto customerDto) {
        long id = customerDto.getId();
        String name = customerDto.getName();
        String email = customerDto.getEmail();
        long countryCode = customerDto.getCountryCode();
        long phone = customerDto.getPhone();
        Boolean status = customerDto.getStatus();
        long agentId = customerDto.getAgentId();

        Customer existingCustomer = customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("customer not found with id " + id ));
        existingCustomer.setId(id);
        existingCustomer.setName(name);
        existingCustomer.setEmail(email);
        existingCustomer.setCountryCode(countryCode);
        existingCustomer.setPhone(phone);
        existingCustomer.setStatus(status);

        customerRepo.save(existingCustomer);
        return existingCustomer;
    }

    public List<CustomerDto> getCustomers() {

        return customerRepo.findAll()
                .stream()
                .map(mapper::mapCustomerToDto)
                .collect(Collectors.toList());
    }
}
