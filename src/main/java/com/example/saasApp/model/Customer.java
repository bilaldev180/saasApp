package com.example.saasApp.model;

import com.example.saasApp.enums.UserType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Customer {
//    @Getter
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long customerId ;
    @Column (name = "customer_name")
    private String name;
    @Column (name = "email")
    private String email;
    @Column (name = "country_code")
    private long countryCode;
    @Column (name = "phone")
    private long phone;
    private Boolean status;
    @Enumerated(EnumType.STRING)
    private UserType userType= UserType.CUSTOMER;
    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    @JsonBackReference // Prevents recursive serialization of the `Agent`
    private Agent agent;
    @OneToOne
    @JoinColumn(name = "kyc_level")
    private KycLevel kycLevel;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL) // Reference to KycRecord
    private KycRecord kycRecord;

}
