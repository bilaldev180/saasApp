package com.example.saasApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name= "kyc_Requirements")
@Data
public class KycRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name= "kyc_level_id", nullable = false)
    private KycLevel kycLevel;
    @Column (name="sequence")
    private Integer Sequence;
    @Column (name="field_name")
    private String fieldName;
    //    private kycFieldType fieldType;
    @Column (name= "validity_period")
    private Integer validityPeriod;
}
