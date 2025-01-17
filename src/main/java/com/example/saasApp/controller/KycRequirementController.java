package com.example.saasApp.controller;

import com.example.saasApp.dto.kycRequirementDTO.KycRequirementRequest;
import com.example.saasApp.dto.kycRequirementDTO.KycRequirementResponse;
import com.example.saasApp.model.KycRequirement;
import com.example.saasApp.service.KycRequirementService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saas/kyc_req")
@AllArgsConstructor
public class KycRequirementController {
    private final KycRequirementService service;

    @PostMapping("/create")
    public KycRequirementResponse create (@RequestBody KycRequirementRequest kycRequirementRequest){
        return service.create(kycRequirementRequest);
    }

    @GetMapping ("/")
    public List<KycRequirementResponse> get (){
        return service.getAll();
    }

    @PatchMapping ("/update")
    public KycRequirement update (@RequestBody KycRequirementRequest kycRequirementRequest){
        return service.update(kycRequirementRequest);
    }

}
