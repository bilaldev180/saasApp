package com.example.saasApp.dto.customerDto;

import com.example.saasApp.model.Agent;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class CustomerDto {
    private long id ;
    private String name;
    private String email;
    private long countryCode;
    private long phone;
    private Boolean status;
    private Long agentId;
}
