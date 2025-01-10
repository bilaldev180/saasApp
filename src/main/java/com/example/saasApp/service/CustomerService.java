package com.example.saasApp.service;

import com.example.saasApp.model.Customer;
import com.example.saasApp.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer create(Customer customer) {
        Customer savedCustomer = customerRepo.save(customer);
        return savedCustomer;
    }
}
