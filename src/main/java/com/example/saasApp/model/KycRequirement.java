package com.example.saasApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "kyc_requirements")
@Data
public class KycRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "kyc_level_id", nullable = false)
    private KycLevel kycLevel;

    @Column(name = "field_name", nullable = false)
    private String fieldName; // Name of the requirement

    @Column(name = "is_mandatory", nullable = false)
    private boolean isMandatory;

    @Column(name = "field_type", nullable = false)
    private String fieldType; // e.g., STRING, PHONE

    @Column(name = "validity_period")
    private Integer validityPeriod; // Validity in days, optional
}
