package com.example.saasApp.controller;

import com.example.saasApp.model.Customer;
import com.example.saasApp.service.KycService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kyc")
public class KycController {

    private final KycService kycService;

    public KycController(KycService kycService) {
        this.kycService = kycService;
    }

    @GetMapping("/validate/{customerId}")
    public ResponseEntity<KycService.ValidationResult> validateCustomerKyc(@PathVariable long customerId) {
        return ResponseEntity.ok(kycService.validateCustomerKyc(customerId));
    }

    @PostMapping("/assign/{customerId}/{kycLevelId}")
    public ResponseEntity<Customer> assignKycLevel(
            @PathVariable long customerId,
            @PathVariable int kycLevelId) {

        Customer updatedCustomer = kycService.assignKycLevelToCustomer(customerId, kycLevelId);
        return ResponseEntity.ok(updatedCustomer);
    }
}
