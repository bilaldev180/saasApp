package com.example.saasApp.dto.kycLevelResponseDto;

import com.example.saasApp.enums.KycLevelName;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class KycLevelRequest {
    private Integer id;
    @Enumerated
    private KycLevelName KycLevelName;
    private String Sequence;
}
