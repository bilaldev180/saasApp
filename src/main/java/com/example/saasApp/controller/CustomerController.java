package com.example.saasApp.controller;

import com.example.saasApp.model.Customer;
import com.example.saasApp.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/saas/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping ("/create")
    public Customer create (@RequestBody Customer customer){
        return customerService.create(customer);
    }
}
