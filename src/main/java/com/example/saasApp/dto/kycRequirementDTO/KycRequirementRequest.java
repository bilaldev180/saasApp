package com.example.saasApp.dto.kycRequirementDTO;

import lombok.Data;

@Data
public class KycRequirementRequest {
    private Integer id;
    private Integer kycLevelId;
//    private Integer Sequence;
    private String fieldName;
    private Boolean isMandatory;
    private String fieldType;
    private Integer validityPeriod;
}
