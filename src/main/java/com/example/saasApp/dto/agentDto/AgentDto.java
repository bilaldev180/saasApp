package com.example.saasApp.dto.agentDto;
import com.example.saasApp.dto.customerDto.CustomerDto;
import lombok.Data;

import java.util.List;

@Data
public class AgentDto {
        private Long id; // Agent's ID
        private String name; // Agent's name
        private long countryCode;
        private long phone;
        private String email; // Agent's email
        private List<CustomerDto> customers; // List of associated customers
}
