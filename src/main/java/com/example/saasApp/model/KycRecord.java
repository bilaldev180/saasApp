//package com.example.saasApp.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import org.hibernate.annotations.CreationTimestamp;
//
//import java.time.LocalDateTime;
//@Entity
//@Table(name = "kyc_records")
//@Data
//public class KycRecord {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @OneToOne
//    @JoinColumn(name = "customer_id", nullable = false)
//    private Customer customer;
//
//    @ManyToOne
//    @JoinColumn(name = "kyc_level_id", nullable = false)
//    private KycLevel kycLevel;
//
//    @Column(name = "status", nullable = false)
//    private String status; // Pending, Approved, Rejected
//}
//
