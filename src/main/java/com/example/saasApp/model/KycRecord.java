package com.example.saasApp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "kyc_record")
@Data
public class KycRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "kyc_level_id", nullable = false) // Reference to KycLevel
    private KycLevel kycLevel;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false) // Reference to Customer
    private Customer customer;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "status")
    private String status; // e.g., "Pending", "Approved", etc.
}
