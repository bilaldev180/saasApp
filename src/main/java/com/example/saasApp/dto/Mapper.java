package com.example.saasApp.dto;

import com.example.saasApp.dto.agentDto.AgentResponse;
import com.example.saasApp.dto.customerDto.CustomerResponse;
import com.example.saasApp.dto.kycLevelResponseDto.KycResponse;
import com.example.saasApp.dto.kycRequirementDTO.KycRequirementResponse;
import com.example.saasApp.model.Agent;
import com.example.saasApp.model.Customer;
import com.example.saasApp.model.KycLevel;
import com.example.saasApp.model.KycRequirement;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public AgentResponse mapAgentToResponse(Agent agent) {
        AgentResponse agentResponse = new AgentResponse();
        agentResponse.setId(agent.getId());
        agentResponse.setName(agent.getName());
        agentResponse.setCountryCode(agent.getCountryCode());
        agentResponse.setPhone(agent.getPhone());
        agentResponse.setEmail(agent.getEmail());

        // Map customers if they exist
        List<CustomerResponse> customerResp = agent.getCustomers() != null
                ? agent.getCustomers().stream()
                .map(this::mapCustomerToResponse)
                .collect(Collectors.toList())
                : null;
        agentResponse.setCustomers(customerResp);

        return agentResponse;
    }

    public CustomerResponse mapCustomerToResponse(Customer customer){
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getCustomerId());
        customerResponse.setName(customer.getName());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setCountryCode(customer.getCountryCode());
        customerResponse.setPhone(customer.getPhone());
        customerResponse.setStatus(customer.getStatus());
        customerResponse.setAgentId(customer.getAgent().getId());

        return customerResponse;
    }

    public KycResponse mapKycLevelToResponse(KycLevel kycLevel){
        KycResponse response = new KycResponse();
        response.setId(kycLevel.getKycLevelId());
        response.setKycLevelName(kycLevel.getKycLevelName().toString());
        response.setSequence(kycLevel.getSequence());
        response.setCreatedAt(kycLevel.getCreatedAt());
        return response;
    }

    public KycRequirementResponse mapKycRequirementToResponse (KycRequirement kycRequirement){
        KycRequirementResponse responseDto = new KycRequirementResponse();
        responseDto.setId(kycRequirement.getId());
        responseDto.setKycLevelId(kycRequirement.getKycLevel().getKycLevelId());
        responseDto.setSequence(kycRequirement.getSequence());
        responseDto.setFieldName(kycRequirement.getFieldName());
        responseDto.setValidityPeriod(kycRequirement.getValidityPeriod());
        return responseDto;
    }
}
