package com.example.saasApp.controller;

import com.example.saasApp.dto.customerDto.CustomerDto;
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
    public Customer create (@RequestBody CustomerDto customerDto){
        return customerService.create(customerDto);
    }

    @PatchMapping ("/update")
    public Customer update(@RequestBody CustomerDto customerDto){
        return customerService.update(customerDto);
    }

    @GetMapping("/")
    public List<CustomerDto> getCustomers (){
        return customerService.getCustomers();
    }
}
