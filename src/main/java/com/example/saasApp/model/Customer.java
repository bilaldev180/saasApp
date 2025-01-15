package com.example.saasApp.model;

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
    private long id ;
    @Column (name = "customer_name")
    private String name;
    @Column (name = "email")
    private String email;
    @Column (name = "country_code")
    private long countryCode;
    @Column (name = "phone")
    private long phone;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    @JsonBackReference // Prevents recursive serialization of the `Agent`
    private Agent agent;

}
