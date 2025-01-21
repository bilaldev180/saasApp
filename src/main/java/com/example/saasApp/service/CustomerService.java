package com.example.saasApp.service;

import com.example.saasApp.dto.Mapper;
import com.example.saasApp.dto.customerDto.CustomerResponse;
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

    public Customer create(CustomerResponse customerResponse) {
       Agent agent = agentRepo.findById(customerResponse.getAgentId())
               .orElseThrow(() -> new RuntimeException("agent not found with id " + customerResponse.getAgentId()));
        Customer customer = new Customer();

        customer.setCustomerId(customerResponse.getId());
        customer.setName(customerResponse.getName());
        customer.setCountryCode(customerResponse.getCountryCode());
        customer.setPhone(customerResponse.getPhone());
        customer.setEmail(customerResponse.getEmail());
        customer.setStatus(customerResponse.getStatus());
        customer.setAgent(agent);

        return customerRepo.save(customer);
    }

    public Customer update(CustomerResponse customerResponse) {
        long id = customerResponse.getId();
        String name = customerResponse.getName();
        String email = customerResponse.getEmail();
        long countryCode = customerResponse.getCountryCode();
        long phone = customerResponse.getPhone();
        Boolean status = customerResponse.getStatus();
        long agentId = customerResponse.getAgentId();

        Customer existingCustomer = customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("customer not found with id " + id ));
        existingCustomer.setCustomerId(id);
        existingCustomer.setName(name);
        existingCustomer.setEmail(email);
        existingCustomer.setCountryCode(countryCode);
        existingCustomer.setPhone(phone);
        existingCustomer.setStatus(status);

        customerRepo.save(existingCustomer);
        return existingCustomer;
    }

    public List<CustomerResponse> getCustomers() {

        return customerRepo.findAll()
                .stream()
                .map(mapper::mapCustomerToResponse)
                .collect(Collectors.toList());
    }

    public String delete(Long id) {
        customerRepo.deleteById(id);
        return "customer deleted successsfully with id " + id;
    }
}
