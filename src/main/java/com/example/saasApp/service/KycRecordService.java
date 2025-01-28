//package com.example.saasApp.service;
//
//import com.example.saasApp.model.Customer;
//import com.example.saasApp.model.KycLevel;
//import com.example.saasApp.model.KycRecord;
//import com.example.saasApp.repo.CustomerRepo;
//import com.example.saasApp.repo.KycLevelRepo;
//import com.example.saasApp.repo.KycRecordRepo;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class KycRecordService {
//
//    private final KycRecordRepo kycRecordRepo;
//    private final KycLevelRepo kycLevelRepo;
//    private final CustomerRepo customerRepo;
//
//
//    public KycRecord create(Integer kycLevelId, Long customerId, String status) {
//        KycLevel kycLevel = kycLevelRepo.findById(kycLevelId)
//                .orElseThrow(() -> new RuntimeException("kycLevelID not found" + kycLevelId));
//        Customer customer = customerRepo.findById(customerId)
//                .orElseThrow(() -> new RuntimeException("customerId not found" + customerId));
//
//        KycRecord kycRecord = new KycRecord();
//        kycRecord.setKycLevel(kycLevel);
//        kycRecord.setCustomer(customer);
//        kycRecord.setStatus(status);
//
//        return kycRecordRepo.save(kycRecord);
//    }
//}