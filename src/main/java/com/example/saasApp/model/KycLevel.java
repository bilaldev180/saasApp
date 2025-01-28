package com.example.saasApp.model;

import com.example.saasApp.enums.KycLevelName;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "kyc_level")
@Data
public class KycLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kycLevelId;

    @Column(name = "kyc_level_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private KycLevelName kycLevelName;

    @Column(name = "sequence", nullable = false)
    private Integer sequence; // Order of KYC levels

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "kycLevel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KycRequirement> requirements;
}
