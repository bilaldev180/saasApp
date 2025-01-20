package com.example.saasApp.model;

import com.example.saasApp.enums.KycLevelName;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name="kyc_level")
@Table(name="kyc_level")
@Data
public class KycLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "kyc_level_name")
    @Enumerated(EnumType.STRING)
    private KycLevelName kycLevelName;
    @Column(name = "Sequence")
    private Integer sequence;
    @CreationTimestamp
    @Column(name = "Created_At", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @OneToOne
    @JoinColumn(name = "kyc_level")
    private Customer customer;
//    @OneToMany (mappedBy = "kycLevel", cascade = CascadeType.ALL, orphanRemoval = false)

    @OneToMany (mappedBy = "kycLevel")
    private List<KycRequirement> requirements;
}
