package com.example.saasApp.dto.kycRequirementDTO;

import lombok.Data;

@Data
public class KycRequirementRequest {
    private Integer id;
    private Integer kycLevelID;
    private Integer Sequence;
    private String fieldName;
    //    private kycFieldType fieldType;
    private Integer validityPeriod;
}
