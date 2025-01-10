package com.example.saasApp.dto.agentDto;

import lombok.Data;

@Data
public class AgentRequest {
    private long pId;
    private String name;
    private String email;

//    private List<Customer> customers;
}
