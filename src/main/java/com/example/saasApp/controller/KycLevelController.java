package com.example.saasApp.controller;

import com.example.saasApp.dto.kycLevelResponseDto.KycLevelRequest;
import com.example.saasApp.dto.kycLevelResponseDto.KycResponse;
import com.example.saasApp.model.KycLevel;
import com.example.saasApp.service.KycLevelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/saas/kyc_level")
@AllArgsConstructor
public class KycLevelController {

    private final KycLevelService kycLevelService;

    @PostMapping ("/create")
    public KycResponse create (@RequestBody KycLevelRequest kycLevelRequest){
        return kycLevelService.createKycLevel(kycLevelRequest);
    }

    @GetMapping("")
    public List<KycResponse> getAllKycLevels(){
        return kycLevelService.getAllKycLevel();
    }

    @GetMapping ("/{id}")
    public KycResponse getKycLevelById (@PathVariable Integer id){
        return kycLevelService.getKycLevelById(id);
    }

    @PatchMapping ("/update")
    public KycLevel updateKycLevel(@RequestBody KycLevelRequest kycLevelRequest ){
        return kycLevelService.updateKycLevel(kycLevelRequest );
    }

    @DeleteMapping ("/{id}")
    public String deleteKycLevelById (@PathVariable int id ){
        kycLevelService.deleteKycLevel(id);
        return "kyc level deleted Successfully" + id;
    }
}
