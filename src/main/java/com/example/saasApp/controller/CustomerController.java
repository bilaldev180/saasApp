package com.example.saasApp.controller;

import com.example.saasApp.dto.customerDto.CustomerResponse;
import com.example.saasApp.model.Customer;
import com.example.saasApp.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/saas/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping ("/create")
    public Customer create (@RequestBody CustomerResponse customerResponse){
        return customerService.create(customerResponse);
    }

    @PatchMapping ("/update")
    public Customer update(@RequestBody CustomerResponse customerResponse){
        return customerService.update(customerResponse);
    }

    @GetMapping("/")
    public List<CustomerResponse> getCustomers (){
        return customerService.getCustomers();
    }
}
