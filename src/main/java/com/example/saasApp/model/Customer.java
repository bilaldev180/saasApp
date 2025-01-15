package com.example.saasApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
//import lombok.Getter;

@Entity
//@Data
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(long countryCode) {
        this.countryCode = countryCode;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
