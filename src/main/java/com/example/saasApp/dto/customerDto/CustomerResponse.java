package com.example.saasApp.dto.customerDto;

import lombok.Data;

@Data
public class CustomerResponse {
    private long id ;
    private String name;
    private String email;
    private String address;
    private long countryCode;
    private long phone;
    private Boolean status;
    private Long agentId;
}
