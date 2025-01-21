package com.example.saasApp.controller;

import com.example.saasApp.model.KycRecord;
import com.example.saasApp.service.KycRecordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/saas/kyc_record")
@AllArgsConstructor
public class KycRecordController {

    private final KycRecordService service;

    @PostMapping ("/")
    public KycRecord create (@RequestParam Integer kycLevelId,
                             @RequestParam Long customerId,
                             @RequestParam String status
                             ){
        return service.create(kycLevelId,customerId,status);
    }

}
