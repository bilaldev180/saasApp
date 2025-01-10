package com.example.saasApp.repo;

import com.example.saasApp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

}
