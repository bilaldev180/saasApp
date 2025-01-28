package com.example.saasApp.model;

import com.example.saasApp.enums.UserType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @Column(name = "customer_name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "country_code", nullable = false)
    private long countryCode;

    @Column(name = "phone", nullable = false)
    private long phone;

    @Column(name = "address")
    private String address;

    private Boolean status = true; // Defaults to active status

    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.CUSTOMER;

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    @JsonBackReference
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "kyc_level_id", nullable = true) // Optional for customers with no KYC
    private KycLevel kycLevel;
}
