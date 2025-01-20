package com.example.saasApp.controller;

import com.example.saasApp.dto.kycRequirementDTO.KycRequirementRequest;
import com.example.saasApp.dto.kycRequirementDTO.KycRequirementResponse;
import com.example.saasApp.model.KycRequirement;
import com.example.saasApp.service.KycRequirementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saas/kyc_req")
@AllArgsConstructor
public class KycRequirementController {

    private final KycRequirementService service;

    @PostMapping("/create")
    public KycRequirementResponse create (@RequestBody KycRequirementResponse kycRequirementResponse){
        return service.create(kycRequirementResponse);
    }

    @GetMapping ("/")
    public List<KycRequirementResponse> get (){
        return service.getAll();
    }
    @GetMapping ("/{id}")
    public KycRequirementResponse getById (@PathVariable Integer id ){
        return service.getById(id);
    }

    @PatchMapping ("/update")
    public KycRequirement update (@RequestBody KycRequirementRequest kycRequirementRequest){
        return service.update(kycRequirementRequest);
    }

    @DeleteMapping ("/{id}")
    public String delete (@PathVariable Integer id ){
        return service.delete(id);
    }

}
