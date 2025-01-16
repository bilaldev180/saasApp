package com.example.saasApp.dto.agentDto;
import com.example.saasApp.dto.customerDto.CustomerResponse;
import lombok.Data;

import java.util.List;

@Data
public class AgentResponse {
        private Long id; // Agent's ID
        private String name; // Agent's name
        private long countryCode;
        private long phone;
        private String email; // Agent's email
        private List<CustomerResponse> customers; // List of associated customers
}
