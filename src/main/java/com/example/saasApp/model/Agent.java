package com.example.saasApp.model;
import com.example.saasApp.enums.UserType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table (name = "agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "parent_id" )
    private Long id;
    @Column (name = "name" , nullable = false)
    private String name;
    @Column (name = "country_code")
    private long countryCode;
    private long phone ;
    @Column(name = "email", nullable = false )
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.AGENT;
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    @JsonManagedReference // Manages the serialization of the `customers` list
    private List<Customer> customers;


}
